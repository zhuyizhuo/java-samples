package com.github.zhuo.algorithm.ratelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 漏桶限流算法实现
 * 以恒定速率处理请求，平滑流量峰值
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class LeakyBucketRateLimiter {
    
    // 桶的容量
    private final long capacity;
    // 漏出速率（每秒处理的请求数）
    private final double leakRate;
    // 当前桶中的水量（请求数）
    private final AtomicLong water = new AtomicLong(0);
    // 上次漏水时间
    private final AtomicLong lastLeakTime = new AtomicLong(System.currentTimeMillis());
    
    /**
     * 构造函数
     * @param capacity 桶的容量
     * @param leakRate 漏出速率（每秒处理的请求数）
     */
    public LeakyBucketRateLimiter(long capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }
    
    /**
     * 尝试获取许可
     * @return 是否允许请求
     */
    public boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        long currentWater = water.get();
        
        // 计算从上一次请求到现在漏掉的水量
        long elapsedTimeMillis = currentTime - lastLeakTime.get();
        // 漏掉的水量 = 时间差（秒） * 漏出速率
        double leakedWater = (elapsedTimeMillis / 1000.0) * leakRate;
        
        // 更新当前水量（如果漏掉的水量大于当前水量，则置为0）
        if (leakedWater > 0) {
            // 计算新的水量
            long newWater = Math.max(0, (long) (currentWater - leakedWater));
            // 更新水量和时间
            water.set(newWater);
            lastLeakTime.set(currentTime);
        }
        
        // 检查是否可以添加新的水（请求）
        if (water.get() < capacity) {
            // 水量加1
            water.incrementAndGet();
            return true;
        }
        
        return false;
    }
    
    /**
     * 获取当前桶中的水量
     * @return 水量
     */
    public long getCurrentWaterLevel() {
        // 先漏水，再返回当前水量
        tryAcquire();
        return water.get();
    }
    
    /**
     * 测试漏桶限流算法
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个漏桶限流器：容量为10，漏出速率为2个请求/秒
        LeakyBucketRateLimiter limiter = new LeakyBucketRateLimiter(10, 2);
        
        System.out.println("模拟突发流量...");
        // 模拟突发流量
        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
        }
        
        System.out.println("当前水量: " + limiter.getCurrentWaterLevel());
        
        // 等待一段时间，让桶中的水流走一部分
        System.out.println("等待3秒让水流走一部分...");
        Thread.sleep(3000);
        
        System.out.println("当前水量: " + limiter.getCurrentWaterLevel());
        
        // 再次测试
        for (int i = 16; i <= 20; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
        }
    }
}
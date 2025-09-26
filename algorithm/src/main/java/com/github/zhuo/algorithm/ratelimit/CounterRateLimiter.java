package com.github.zhuo.algorithm.ratelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 计数器限流算法实现
 * 最简单的限流实现，基于时间周期计数
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class CounterRateLimiter {
    
    // 时间窗口大小（毫秒）
    private final long windowSize;
    // 时间窗口内最大请求数
    private final int maxRequests;
    // 当前时间窗口的请求计数
    private final AtomicInteger count = new AtomicInteger(0);
    // 当前时间窗口的开始时间
    private final AtomicLong windowStart = new AtomicLong(System.currentTimeMillis());
    
    /**
     * 构造函数
     * @param maxRequests 时间窗口内最大请求数
     * @param timeUnit 时间单位
     * @param windowDuration 时间窗口大小
     */
    public CounterRateLimiter(int maxRequests, TimeUnit timeUnit, long windowDuration) {
        this.maxRequests = maxRequests;
        this.windowSize = timeUnit.toMillis(windowDuration);
    }
    
    /**
     * 尝试获取许可
     * @return 是否允许请求
     */
    public boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        long currentWindowStart = windowStart.get();
        
        // 检查是否进入了新的时间窗口
        if (currentTime - currentWindowStart > windowSize) {
            // 重置计数器和时间窗口
            if (windowStart.compareAndSet(currentWindowStart, currentTime)) {
                count.set(0);
            }
            // 双重检查，确保只有一个线程重置了计数器
            currentWindowStart = windowStart.get();
            if (currentTime - currentWindowStart > windowSize) {
                // 如果还是在新的窗口外，说明有其他线程已经重置了计数器
                return false;
            }
        }
        
        // 检查请求数是否超过限制
        int currentCount = count.incrementAndGet();
        return currentCount <= maxRequests;
    }
    
    /**
     * 获取当前窗口内的请求数
     * @return 请求数
     */
    public int getCurrentCount() {
        long currentTime = System.currentTimeMillis();
        long currentWindowStart = windowStart.get();
        
        // 如果已经进入新的窗口，返回0
        if (currentTime - currentWindowStart > windowSize) {
            return 0;
        }
        
        return count.get();
    }
    
    /**
     * 测试计数器限流算法
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个计数器限流器：5秒内最多处理10个请求
        CounterRateLimiter limiter = new CounterRateLimiter(10, TimeUnit.SECONDS, 5);
        
        System.out.println("测试计数器限流算法...");
        // 发送15个请求
        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
        }
        
        System.out.println("当前窗口请求数: " + limiter.getCurrentCount());
        
        // 等待6秒，进入下一个时间窗口
        System.out.println("等待6秒进入下一个时间窗口...");
        Thread.sleep(6000);
        
        System.out.println("当前窗口请求数: " + limiter.getCurrentCount());
        
        // 再次发送10个请求
        for (int i = 16; i <= 25; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
        }
    }
}
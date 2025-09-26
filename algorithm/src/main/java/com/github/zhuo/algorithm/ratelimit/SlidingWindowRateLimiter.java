package com.github.zhuo.algorithm.ratelimit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * 滑动窗口限流算法实现
 * 通过时间窗口控制请求数量，比固定窗口算法更精确
 * 时间复杂度：O(1)
 * 空间复杂度：O(windowSize)
 */
public class SlidingWindowRateLimiter {
    
    // 请求队列，存储每个请求的时间戳
    private final Queue<Long> requestQueue;
    // 时间窗口大小（毫秒）
    private final long windowSize;
    // 最大请求数量
    private final int maxRequests;
    
    /**
     * 构造函数
     * @param maxRequests 时间窗口内最大请求数
     * @param timeUnit 时间单位
     * @param windowDuration 时间窗口大小
     */
    public SlidingWindowRateLimiter(int maxRequests, TimeUnit timeUnit, long windowDuration) {
        this.maxRequests = maxRequests;
        this.windowSize = timeUnit.toMillis(windowDuration);
        this.requestQueue = new LinkedList<>();
    }
    
    /**
     * 尝试获取许可
     * @return 是否允许请求
     */
    public synchronized boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        
        // 移除过期的请求时间戳
        removeExpiredRequests(currentTime);
        
        // 检查是否超过最大请求数
        if (requestQueue.size() < maxRequests) {
            // 添加当前请求时间戳
            requestQueue.offer(currentTime);
            return true;
        }
        
        return false;
    }
    
    /**
     * 移除过期的请求时间戳
     * @param currentTime 当前时间戳
     */
    private void removeExpiredRequests(long currentTime) {
        // 移除时间窗口外的请求
        while (!requestQueue.isEmpty() && currentTime - requestQueue.peek() > windowSize) {
            requestQueue.poll();
        }
    }
    
    /**
     * 获取当前窗口内的请求数
     * @return 请求数
     */
    public synchronized int getCurrentRequests() {
        removeExpiredRequests(System.currentTimeMillis());
        return requestQueue.size();
    }
    
    /**
     * 测试滑动窗口限流算法
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个滑动窗口限流器：10秒内最多处理5个请求
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(5, TimeUnit.SECONDS, 10);
        
        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
            Thread.sleep(1000);
        }
        
        // 等待5秒后，窗口滑动，之前的请求会被移除
        System.out.println("等待5秒...");
        Thread.sleep(5000);
        
        for (int i = 11; i <= 15; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
            Thread.sleep(1000);
        }
    }
}
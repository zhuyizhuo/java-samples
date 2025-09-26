package com.github.zhuo.algorithm.ratelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 令牌桶限流算法实现
 * 允许一定程度的突发流量，更加灵活
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class TokenBucketRateLimiter {
    
    // 桶的容量
    private final long capacity;
    // 令牌生成速率（每秒生成的令牌数）
    private final double tokenRate;
    // 当前桶中的令牌数
    private final AtomicLong tokens = new AtomicLong(0);
    // 上次生成令牌的时间
    private final AtomicLong lastRefillTime = new AtomicLong(System.currentTimeMillis());
    
    /**
     * 构造函数
     * @param capacity 桶的容量
     * @param tokenRate 令牌生成速率（每秒生成的令牌数）
     */
    public TokenBucketRateLimiter(long capacity, double tokenRate) {
        this.capacity = capacity;
        this.tokenRate = tokenRate;
        // 初始时桶是满的
        this.tokens.set(capacity);
    }
    
    /**
     * 尝试获取一个令牌
     * @return 是否获取成功
     */
    public boolean tryAcquire() {
        // 尝试获取一个令牌
        return tryAcquire(1);
    }
    
    /**
     * 尝试获取指定数量的令牌
     * @param permits 需要获取的令牌数
     * @return 是否获取成功
     */
    public synchronized boolean tryAcquire(int permits) {
        // 检查参数是否合法
        if (permits <= 0) {
            throw new IllegalArgumentException("Permits must be positive");
        }
        
        // 先添加令牌
        addTokens();
        
        // 尝试获取令牌
        long currentTokens = tokens.get();
        if (currentTokens >= permits) {
            // 成功获取令牌
            tokens.set(currentTokens - permits);
            return true;
        }
        
        return false;
    }
    
    /**
     * 添加令牌
     */
    private void addTokens() {
        long currentTime = System.currentTimeMillis();
        long lastTime = lastRefillTime.get();
        
        // 如果当前时间大于上次生成令牌的时间，则生成新的令牌
        if (currentTime > lastTime) {
            // 计算时间差
            double elapsedTimeSeconds = (currentTime - lastTime) / 1000.0;
            // 计算应该生成的令牌数
            long newTokens = (long) (elapsedTimeSeconds * tokenRate);
            
            if (newTokens > 0) {
                // 计算新的令牌总数（不超过桶的容量）
                long currentTokens = tokens.get();
                long updatedTokens = Math.min(currentTokens + newTokens, capacity);
                // 更新令牌数和时间
                tokens.set(updatedTokens);
                lastRefillTime.set(currentTime);
            }
        }
    }
    
    /**
     * 获取当前桶中的令牌数
     * @return 令牌数
     */
    public long getCurrentTokens() {
        // 先添加令牌，再返回当前令牌数
        addTokens();
        return tokens.get();
    }
    
    /**
     * 测试令牌桶限流算法
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个令牌桶限流器：容量为10，令牌生成速率为5个/秒
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(10, 5);
        
        System.out.println("初始令牌数: " + limiter.getCurrentTokens());
        
        // 模拟突发流量，消耗所有令牌
        System.out.println("消耗所有令牌...");
        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
        }
        
        System.out.println("剩余令牌数: " + limiter.getCurrentTokens());
        
        // 尝试获取一个令牌，应该被拒绝
        boolean allowed = limiter.tryAcquire();
        System.out.println("请求 11: " + (allowed ? "允许" : "拒绝"));
        
        // 等待一段时间，让令牌桶生成一些令牌
        System.out.println("等待2秒让令牌生成...");
        Thread.sleep(2000);
        
        System.out.println("当前令牌数: " + limiter.getCurrentTokens());
        
        // 再次尝试获取令牌
        for (int i = 12; i <= 20; i++) {
            allowed = limiter.tryAcquire();
            System.out.println("请求 " + i + ": " + (allowed ? "允许" : "拒绝"));
        }
    }
}
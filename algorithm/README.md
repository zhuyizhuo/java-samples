# 算法实现项目

本模块整理了各类算法的Java实现，记录算法的实现思路和复杂度分析，便于学习和参考。

## 项目结构

```
algorithm/
├── src/main/java/     # 主要算法实现代码
└── src/test/java/     # 算法测试代码
```

## 算法分类

### 一、LeetCode算法题

包含各类LeetCode题目的Java实现，按照难度和类型进行分类。

- [LeetCode官网](https://leetcode.com/problemset/all/)

### 二、LintCode算法题

包含各类LintCode题目的Java实现，涵盖不同的数据结构和算法类型。

- [LintCode官网](https://www.lintcode.com/problem/)

### 三、经典排序算法

实现了8大经典排序算法的Java版本，包含详细的注释和复杂度分析：

1. **直接插入排序** - 稳定排序，平均时间复杂度O(n²)
   - [InsertionSort.java](src/main/java/com/github/zhuo/algorithm/sort/InsertionSort.java)
   
2. **希尔排序** - 不稳定排序，平均时间复杂度O(n^1.3)
   - [ShellSort.java](src/main/java/com/github/zhuo/algorithm/sort/ShellSort.java)
   
3. **简单选择排序** - 不稳定排序，平均时间复杂度O(n²)
   - [SelectionSort.java](src/main/java/com/github/zhuo/algorithm/sort/SelectionSort.java)
   
4. **堆排序** - 不稳定排序，平均时间复杂度O(nlogn)
   - [HeapSort.java](src/main/java/com/github/zhuo/algorithm/sort/HeapSort.java)
   
5. **冒泡排序** - 稳定排序，平均时间复杂度O(n²)
   - [BubbleSort.java](src/main/java/com/github/zhuo/algorithm/sort/BubbleSort.java)
   
6. **快速排序** - 不稳定排序，平均时间复杂度O(nlogn)
   - [QuickSort.java](src/main/java/com/github/zhuo/algorithm/sort/QuickSort.java)
   
7. **归并排序** - 稳定排序，平均时间复杂度O(nlogn)
   - [MergeSort.java](src/main/java/com/github/zhuo/algorithm/sort/MergeSort.java)
   
8. **基数排序** - 稳定排序，平均时间复杂度O(d(n+r))，其中d是位数，r是基数
   - [RadixSort.java](src/main/java/com/github/zhuo/algorithm/sort/RadixSort.java)

### 四、常用限流算法

实现了四种常见的限流算法，用于控制系统流量：

1. **滑动窗口算法** - 更精确的流量控制，避免计数器算法的边界问题
   [SlidingWindowRateLimiter.java](src/main/java/com/github/zhuo/algorithm/ratelimit/SlidingWindowRateLimiter.java)

2. **漏桶算法** - 以恒定速率处理请求，平滑流量峰值
   [LeakyBucketRateLimiter.java](src/main/java/com/github/zhuo/algorithm/ratelimit/LeakyBucketRateLimiter.java)

3. **令牌桶算法** - 允许一定程度的突发流量，更加灵活
   [TokenBucketRateLimiter.java](src/main/java/com/github/zhuo/algorithm/ratelimit/TokenBucketRateLimiter.java)

4. **计数器算法** - 最简单的限流实现，基于时间周期计数
   [CounterRateLimiter.java](src/main/java/com/github/zhuo/algorithm/ratelimit/CounterRateLimiter.java)

### 五、数字压缩算法

- **ZigZag编码** - 用于Protocol Buffers等序列化框架中的整数压缩

### 六、散列算法

散列算法一般用于生成数据的摘要信息，是一种不可逆的算法，适合存储密码等敏感数据。
实现了多种常见的散列算法：

- MD5 - 128位摘要 [HashUtils.java](src/main/java/com/github/zhuo/algorithm/utils/HashUtils.java)
- SHA1 - 160位摘要 [HashUtils.java](src/main/java/com/github/zhuo/algorithm/utils/HashUtils.java)
- SHA256 - 256位摘要 [HashUtils.java](src/main/java/com/github/zhuo/algorithm/utils/HashUtils.java)
- SHA512 - 512位摘要 [HashUtils.java](src/main/java/com/github/zhuo/algorithm/utils/HashUtils.java)

> 注意：进行密码散列时，建议使用salt（盐）增加安全性。

## 使用说明

### 运行测试

项目使用Maven管理，可以通过以下命令运行测试：

```bash
mvn test
```

### 代码示例

每个算法实现都包含详细的注释和使用示例，可以直接在代码中查看。

## 学习资源

- [算法导论](https://mitpress.mit.edu/books/introduction-algorithms)
- [数据结构与算法分析](https://book.douban.com/subject/1139426/)

## 许可证

[Apache License 2.0](../LICENSE)

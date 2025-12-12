# Java Samples
这是一个Java学习和示例代码仓库，包含了多个子模块，涵盖了Java基础、算法实现、Java高级特性等方面的示例代码。

## 项目结构

- [algorithm](algorithm/README.md) - 算法实现和LeetCode题解
- [java-agent](java-agent/README.md) - Java Agent技术示例
- [java-spi](java-spi/README.md) - Java SPI机制示例

## 模块详情

### algorithm

整理各类算法的实现，记录算法的实现思路。

- **LeetCode算法题** - 各种LeetCode题目的Java实现
- **LintCode算法题** - 各种LintCode题目的Java实现
- **8大排序算法** - 包含直接插入排序、希尔排序、简单选择排序、堆排序、冒泡排序、快速排序、归并排序、基数排序
- **常用限流算法** - 包含滑动窗口协议、漏桶、令牌桶、计数器
- **数字压缩算法** - 如zigzag编码
- **散列算法** - 如MD5、SHA1、SHA256、SHA512等

### java-agent

在JDK1.5以后，可以使用agent技术构建一个独立于应用程序的代理程序（即为Agent），用来协助监测、运行甚至替换其他JVM上的程序。使用它可以实现虚拟机级别的AOP功能。

模块包含详细的打包和测试命令说明，以及测试脚本。

### java-spi

SPI（Service Provider Interface）是Java提供的一种服务发现机制。

面向对象的设计中，我们一般推荐模块之间基于接口编程，模块之间不对实现类进行硬编码。一旦代码里涉及具体的实现类，就违反了可拔插的原则。Java SPI提供了一种为某个接口寻找服务实现的机制，将装配的控制权移到了程序之外。

该模块分为三个子项目：
- spi-service - 服务接口定义
- spi-impl - 服务接口实现
- spi-client - 客户端使用示例

## 使用说明

请参考各个子模块的README文件获取详细的使用说明。

## 许可证

[MIT License](LICENSE)
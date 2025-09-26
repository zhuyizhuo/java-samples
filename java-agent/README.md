# Java Agent技术示例

本模块演示了Java Agent技术的基本原理和使用方法。Java Agent是JDK 1.5引入的一项技术，允许开发者构建一个独立于应用程序的代理程序，用于监测、修改甚至替换JVM上运行的程序行为，实现虚拟机级别的AOP功能。

## 项目结构

```
java-agent/
├── agent/          # Agent实现代码
│   └── src/        # Agent源代码
├── demo/           # 被代理的示例应用
│   └── src/        # 示例应用源代码
├── TestAgent.sh    # 测试脚本
└── README.md       # 项目说明文档
```

## Java Agent技术介绍

Java Agent是一种特殊的Java程序，它能在JVM启动时或运行时被加载，并通过Instrumentation API修改其他类的字节码。主要用途包括：

- **性能监控** - 收集方法执行时间、内存使用等性能指标
- **代码注入** - 在不修改源代码的情况下增强现有功能
- **故障诊断** - 实时监控和诊断应用程序问题
- **类重定义** - 在运行时替换或修改类的实现

## 快速开始

### 方法一：使用测试脚本

项目提供了便捷的测试脚本，可以一键完成编译、打包和运行测试：

```bash
# 运行测试脚本
bash TestAgent.sh
```

### 方法二：手动编译运行

#### 1. 编译和打包示例应用

```bash
# 进入示例应用目录
cd demo/src

# 编译示例应用
javac com/zhuyizhuo/example/java/agent/test/AgentDemo.java

# 打JAR包
jar -cvfm AgentDemo.jar META-INF/MANIFEST.MF com/zhuyizhuo/example/java/agent/test/AgentDemo.class

# 验证示例应用
java -jar AgentDemo.jar
```

#### 2. 编译和打包Agent

```bash
# 进入Agent目录
cd agent/src

# 编译Agent
javac com/zhuyizhuo/example/java/agent/TestAgent.java 

# 打Agent JAR包
jar -cvfm Agent.jar META-INF/MANIFEST.MF com/zhuyizhuo/example/java/agent/TestAgent.class
```

#### 3. 运行带Agent的应用

```bash
# 使用Agent启动应用（可以同时使用多个Agent）
java -javaagent:Agent.jar=one -javaagent:Agent.jar=two -jar AgentDemo.jar
```

## 核心概念解析

### 1. Agent的两种启动方式

- **静态Instrumentation** - 通过`-javaagent`参数在JVM启动时加载
- **动态Instrumentation** - 在JVM运行时通过Attach API动态加载

### 2. Agent的主要入口方法

```java
// JVM启动时调用的方法
public static void premain(String args, Instrumentation inst) {
    // Agent初始化代码
}

// JVM运行时动态Attach调用的方法
public static void agentmain(String args, Instrumentation inst) {
    // Agent初始化代码
}
```

### 3. Instrumentation API的主要功能

- **addTransformer** - 添加字节码转换器
- **redefineClasses** - 重定义类的字节码
- **getAllLoadedClasses** - 获取所有已加载的类
- **getObjectSize** - 获取对象的大小

## 常见问题解答

1. **Q: 为什么需要在MANIFEST.MF中指定Premain-Class？**
   A: 这是JVM识别Agent入口类的标准方式，JVM会根据这个配置找到并调用premain方法。

2. **Q: 一个应用可以同时使用多个Agent吗？**
   A: 是的，可以通过多个`-javaagent`参数指定多个Agent，它们会按照指定的顺序执行。

3. **Q: Agent可以修改JDK自带的类吗？**
   A: 默认情况下不可以，但可以通过`-XX:+UnlockCommercialFeatures -XX:+LogCompilation`参数开启对JDK类的修改。

## 学习资源

- [Java Instrumentation API官方文档](https://docs.oracle.com/en/java/javase/11/docs/api/java.instrument/java/lang/instrument/package-summary.html)
- [JVM Tool Interface官方文档](https://docs.oracle.com/en/java/javase/11/docs/specs/jvmti.html)

## 许可证

[MIT License](https://github.com/zhuyizhuo/java-samples/blob/master/LICENSE)
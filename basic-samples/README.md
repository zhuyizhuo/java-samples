# Java基础示例

本模块包含Java基础API的使用示例，旨在展示Java核心功能的最佳实践和常见用法。

## 项目结构

```
basic-samples/
├── src/main/java/     # 主要示例代码
└── pom.xml            # Maven项目配置文件
```

## 示例列表

### 1. Java 8 API示例

#### Predicate接口使用示例

`PredicateSample`类展示了Java 8中`Predicate`函数式接口的各种使用方式，包括：

- 基本的断言测试
- 复合谓词（and、or、negate）
- 谓词链
- 与Stream API结合使用

### 2. 后续将添加更多示例

计划添加的示例包括：

- Optional类的正确使用
- Stream API高级用法
- Java集合框架最佳实践
- 多线程编程示例
- 日期时间API使用

## 使用说明

### 运行示例

项目使用Maven管理，可以通过以下命令编译和运行示例：

```bash
# 编译项目
mvn compile

# 运行特定示例
mvn exec:java -Dexec.mainClass="com.zhuyizhuo.example.java.basic.PredicateSample"
```

### 代码示例

#### PredicateSample示例代码片段

```java
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateSample {
    public static void main(String[] args) {
        // 创建基本谓词
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEven = n -> n % 2 == 0;
        
        // 测试单个谓词
        System.out.println("Is 5 positive? " + isPositive.test(5));
        System.out.println("Is 5 even? " + isEven.test(5));
        
        // 复合谓词 - 正偶数
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        System.out.println("Is 6 positive and even? " + isPositiveAndEven.test(6));
        
        // 与Stream API结合使用
        List<Integer> numbers = Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
        List<Integer> positiveNumbers = numbers.stream()
                .filter(isPositive)
                .collect(Collectors.toList());
        
        System.out.println("Positive numbers: " + positiveNumbers);
    }
}
```

## 学习资源

- [Java官方文档](https://docs.oracle.com/en/java/)
- [Java 8函数式编程指南](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

## 许可证

[MIT License](https://github.com/zhuyizhuo/java-samples/blob/master/LICENSE)
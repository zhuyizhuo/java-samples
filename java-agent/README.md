## java-agent 简介
在JDK1.5以后，我们可以使用agent技术构建一个独立于应用程序的代理程序（即为Agent），
用来协助监测、运行甚至替换其他JVM上的程序。使用它可以实现虚拟机级别的AOP功能。

## 打 jar 包命令
cd java-samples/java-agent/demo/src
### 编译
javac com/zhuyizhuo/example/java/agent/test/AgentDemo.java
### 打jar包
jar -cvfm AgentDemo.jar  META-INF/MANIFEST.MF com/zhuyizhuo/example/java/agent/test/AgentDemo.class
### 验证
java -jar AgentDemo.jar


java -javaagent:\java_agent_jar\java-agent.jar=helloworld1 
-javaagent:\java_agent_jar\java-agent.jar=helloworld2 
-jar test-agent.jar
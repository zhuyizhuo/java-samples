#!/bin/bash

dir="demo/src/"
printf "进入目录 "
cd $dir
pwd
echo "编译"
javac com/zhuyizhuo/example/java/agent/test/AgentDemo.java
echo "编译完成,AgentDemo.jar 打包开始"
jar -cvfm AgentDemo.jar META-INF/MANIFEST.MF com/zhuyizhuo/example/java/agent/test/AgentDemo.class
echo "AgentDemo.jar 打包完成,执行验证"
java -jar AgentDemo.jar

printf "\n移动 AgentDemo.jar 包至 "
mv AgentDemo.jar ../../
cd ../../
pwd

dir="agent/src/"
printf "\n进入目录"
cd $dir
pwd
javac com/zhuyizhuo/example/java/agent/TestAgent.java
echo "编译完成,Agent.jar 打包开始"
jar -cvfm Agent.jar META-INF/MANIFEST.MF com/zhuyizhuo/example/java/agent/TestAgent.class
echo "Agent.jar 打包完成"

printf "\n移动 Agent.jar 包至 "
mv Agent.jar ../../
cd ../../
pwd

printf "\n测试 java-agent \n\n"
java -javaagent:Agent.jar=one -javaagent:Agent.jar=two -jar AgentDemo.jar

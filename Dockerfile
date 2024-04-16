# 基于Java运行时环境的镜像
FROM openjdk:11-jdk-alpine

# 变量，表示传递到java -jar命令的参数
ARG JAR_FILE=blog-service.jar

# 将打包的jar文件复制到容器中
COPY ${JAR_FILE} blog-service.jar

# 暴露容器的端口，这里假设你的应用运行在8080端口
EXPOSE 8099

# 运行jar文件
ENTRYPOINT ["java","-jar","/blog-service.jar"]

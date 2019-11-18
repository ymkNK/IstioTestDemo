# 拉取JDK11的系统镜像
# From java:11
From openjdk:11
# 设置时区
ENV TZ=Asia/Shanghai
# 时区写入系统文件
RUN ln -snf /usr/share/zoneinfo/$TZ  /etc/localtime && echo $TZ > /etc/timezone

VOLUME /tmp
# 加入打包好的jar文件(xxxxx改为自己文件名)
ADD ./target/demo-0.0.1-SNAPSHOT.jar /

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo-0.0.1-SNAPSHOT.jar"]
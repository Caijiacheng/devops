FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
#ENV JAVA_OPTS="-Dcom.sun.management.jmxremote.port=39083 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
ENV JAVA_OPTS=""
COPY localtime /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
ONBUILD COPY app.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
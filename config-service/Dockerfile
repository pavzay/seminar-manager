FROM java:8-jre
MAINTAINER Pavel Zaichyk <zaychick.pav@yandex.ru>

ADD ./build/libs/config-service*.jar /app/config-service.jar
CMD ["java","-jar","/app/config-service.jar"]

EXPOSE 8888

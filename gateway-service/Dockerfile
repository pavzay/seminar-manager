FROM java:8-jre
MAINTAINER Pavel Zaichyk <zaychick.pav@yandex.ru>

ADD ./build/libs/gateway-service*.jar /app/gateway-service.jar
CMD ["java","-jar","/app/gateway-service.jar"]

EXPOSE 8080

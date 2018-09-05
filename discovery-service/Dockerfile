FROM java:8-jre
MAINTAINER Pavel Zaichyk <zaychick.pav@yandex.ru>

ADD ./build/libs/discovery-service*.jar /app/discovery-service.jar
CMD ["java","-jar","/app/discovery-service.jar"]

EXPOSE 8761

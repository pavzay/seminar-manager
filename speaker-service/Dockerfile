FROM java:8-jre
MAINTAINER Pavel Zaichyk <zaychick.pav@yandex.ru>

ADD ./build/libs/speaker-service*.jar /app/speaker-service.jar
CMD ["java","-jar","/app/speaker-service.jar"]

EXPOSE 8083

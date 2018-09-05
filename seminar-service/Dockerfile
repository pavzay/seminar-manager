FROM java:8-jre
MAINTAINER Pavel Zaichyk <zaychick.pav@yandex.ru>

ADD ./build/libs/seminar-service*.jar /app/seminar-service.jar
CMD ["java","-jar","/app/seminar-service.jar"]

EXPOSE 8082

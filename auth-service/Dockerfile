FROM java:8-jre
MAINTAINER Pavel Zaichyk <zaychick.pav@yandex.ru>

ADD ./build/libs/auth-service*.jar /app/auth-service.jar
CMD ["java","-jar","/app/auth-service.jar"]

EXPOSE 5000

FROM maven:3.9.5-eclipse-temurin-17-alpine

EXPOSE 8080

# maven修改国内地址
COPY cicd/maven-settings.xml /usr/share/maven/conf/settings.xml

WORKDIR /app
COPY . .
RUN mvn package

CMD java -jar start/target/start.jar

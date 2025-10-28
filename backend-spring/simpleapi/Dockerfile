# Build stage
FROM eclipse-temurin:21-jdk-alpine AS myapp-build
ENV MYAPP_HOME=/opt/myapp
WORKDIR $MYAPP_HOME
RUN apk add --no-cache maven
COPY pom.xml .
COPY src ./src
# Build with retries to handle transient Maven Central issues
RUN mvn -q -DskipTests \
    -Dmaven.wagon.http.retryHandler.count=3 \
    -Dmaven.wagon.httpconnectionManager.ttlSeconds=60 \
    package

# Run stage
FROM eclipse-temurin:21-jre-alpine
ENV MYAPP_HOME=/opt/myapp
WORKDIR $MYAPP_HOME
COPY --from=myapp-build $MYAPP_HOME/target/*.jar $MYAPP_HOME/myapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","myapp.jar"]

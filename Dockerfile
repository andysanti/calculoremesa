FROM amd64/eclipse-temurin:17-jdk-ubi9-minimal

WORKDIR /root

COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

RUN ./mvnw dependency:go-offline

COPY ./src /root/src

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java","-jar","/root/target/calculoremesa-0.0.1-SNAPSHOT.jar"]
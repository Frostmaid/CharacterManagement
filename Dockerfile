FROM openjdk:8-jre-alpine

ENV APPLICATION_USER ktor
RUN adduser -D -g '' $APPLICATION_USER

RUN mkdir /app
RUN chown -R $APPLICATION_USER /app

USER $APPLICATION_USER

COPY ./backend/build/libs/backend-1.0.0-SNAPSHOT.jar /app/backend-1.0.0-SNAPSHOT.jar
WORKDIR /app

CMD ["java", "-jar", "backend-1.0.0-SNAPSHOT.jar"]


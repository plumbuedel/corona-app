FROM gradle:6.6.1-jdk8 as build

WORKDIR /app

COPY build.gradle .
COPY src src

RUN gradle build --stacktrace -x test 
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/app/build/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

RUN addgroup -S getReadyPlayerOne && adduser -S  getReadyPlayerOne -G getReadyPlayerOne
USER getReadyPlayerOne:getReadyPlayerOne

EXPOSE 8080

ENTRYPOINT ["java","-cp","app:app/lib/*","de.fak73.coronaapi.CoronaApiApplication"]

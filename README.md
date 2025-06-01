# Spring Boot OpenTelemetry demo

The purpose of this project is to experiment with OpenTelemetry on SpringBoot ecosystem. The project start a simple
reactive SpringBoot application, which exports the sampled traces and logs to a OpenTelemetry collector running as a local
container. Right now the application is integrated with the following systems:

- MongoDB (running as local container)
- H2 (running in memory)
- Kafka (running as local container)

Two branches besides `master` exists on this project. The first one `opentelemetry-springboot-starter` instruments the
application using `opentelemetry-spring-boot-starter` library. The second one `java-agent` instruments the application
using the open telemetry java agent. The purpose of these branches is to compare the results between these two forms
of instrumentation.

In the future more integrations could be added to the application (like a external cache system) to see the behavior of
instrumentation on these integrations.

## How to run

The requirements to run the application are:

- JDK 21
- Docker compose

First start the required local containers:
```
./start-compose-with-collector-grep.sh
```
Wait for all containers to start then run:
```
./gradlew bootRun
```

## How to use

- Generate kafka data for instrumentation: the application will periodically produce messages on a topic which will be
consumed.
- Generate http data for instrumentation: run the script `generate-random-http-request.sh`.

The collected data should be visible on the terminal which launched the local containers (you can search for `Span #`)
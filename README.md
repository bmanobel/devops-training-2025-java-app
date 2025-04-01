# CI / CD Strategy with Docker

## Create Java APP Docker image
```bash
$ docker-compose up -d sonarqube
$ docker build -t scalian_training-java-hello-world-build:0.0.2-SNAPSHOT --build-arg VERSION=0.0.2-SNAPSHOT  -f devops/build.Dockerfile .
$ docker build -t scalian_training-java-hello-world:0.0.2  --build-arg VERSION=0.0.2-SNAPSHOT -f devops/Dockerfile .

$ docker run -d --rm -p 8085:8080  --name java-app   scalian_training-java-hello-world:0.0.2
$ curl localhost:8084/hello
$ docker stop java-app
$ 
```

## Verify sonarqube project
```bash
$ docker run \
    --rm  -w /app \
    -v "c:/Users/a.contreras/Documents/workspaces/training/training-java-hello-world:/app" \
    --network jenkins_scalian_training-net \
    maven:3.8.6-openjdk-11-slim \
    mvn verify sonar:sonar \
    -Dsonar.projectKey=java-example-manual \
    -Dsonar.host.url=http://172.16.235.10:9000 \
    -Dsonar.login=sqp_bffead96e1a5bb8496ff6660825dff8fd8feb2e7
```

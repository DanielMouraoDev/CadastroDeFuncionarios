FROM eclipse-temurin:17
LABEL mainteiner="danielmouraodev777@gmail.com"
WORKDIR /app
COPY target/CadastroDeFuncionarios-0.0.1-SNAPSHOT.jar /app/cadastro-de-funcionarios.jar
ENTRYPOINT ["java", "-jar", "cadastro-de-funcionarios.jar"]
FROM openjdk:17
LABEL authors="kingsleythomas"

WORKDIR /app

COPY target/produit.jar ./produit.jar
EXPOSE 8080

CMD ["java", "-jar","produit.jar"]
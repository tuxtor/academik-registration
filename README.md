# Build
mvn clean package && docker build -t io.academik/academik-registration .

# RUN

docker rm -f academik-registration || true && docker run -d -p 8080:8080 -p 4848:4848 --name academik-registration io.academik/academik-registration 
1. Iniciar Start Docker Service
   & Clicar em Docker Desktop


2. docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -e MYSQL_DATABASE=lacvita \
    -p 3306:3306 \
    mysql

3. ./mvnw spring-boot:run
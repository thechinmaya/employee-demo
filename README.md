# employee-demo
## employee demo using Angular 7 and Spring boot 2

if you don't have npm in your system then install it now

ubuntu : sudo apt install npm

windows : Get it from https://nodejs.org/en/



## Steps to run the application

git clone or download this project

extract the zip and go inside the directory

cd employee-demo

### to start the sprint boot backend application

cd employee-server

mvn spring-boot:run

Check the api spec by visiting http://localhost:8080/swagger-ui.html

### to start the client web app

cd employee-client

npm install

ng serve --watch=false

application can now be accessed via http://localhost:4200

longin details: admin/admin

### NOTE

- Add Employee operation is pending
- Test cases are pending
- Current implementation does not include authentication and authorization




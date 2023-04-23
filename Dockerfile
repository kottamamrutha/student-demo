FROM openjdk:17
EXPOSE 9002
COPY target/student-demo.jar student-demo.jar
CMD ["java","-jar","student-demo.jar"]
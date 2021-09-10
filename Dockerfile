FROM adoptopenjdk/openjdk11:latest
COPY ./giphy_giver-0.0.1.jar ./opt
ENTRYPOINT ["java","-jar","/opt/giphy_giver-0.0.1.jar"]
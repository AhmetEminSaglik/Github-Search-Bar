FROM openjdk:8
ADD target/GithubSearchBar-1.0-SNAPSHOT.jar GithubSearchBar-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","GithubSearchBar-1.0-SNAPSHOT.jar"]
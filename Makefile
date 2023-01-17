.PHONY: app-build app-build-no-tests start image-build

app-build:
	#mvn package spring-boot:repackage
	@ mvn clean package
	#java -jar  ./target/elfin-tech-1.0.0-SNAPSHOT.jar
	#java -jar -Dspring.profiles.active=demo ./target/elfin-tech-1.0.0-SNAPSHOT-jar-with-dependencies.jar

start:
	@ docker-compose up -d postgres elasticsearch

stop:
	@ docker-compose down -v

image-build:
	@ docker build -t interview-app:1 -f ./Dockerfile .

start-all:
	@ make app-build
	@ make start
	@ make image-build
	@ docker-compose up -d app
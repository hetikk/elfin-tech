.PHONY: app-build app-build-no-tests start image-build

app-build:
	@ mvn clean package

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
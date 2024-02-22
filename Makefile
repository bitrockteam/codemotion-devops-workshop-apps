package:
	mvn install

docker-build: package
	docker build -t bitripa/springboot-sample-app:latest .

docker-push:
	docker push bitripa/springboot-sample-app:latest

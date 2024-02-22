package:
	mvn install

docker: package
	docker build -t bitripa/springboot-sample-app:$(version) .
	docker push bitripa/springboot-sample-app:$(version)

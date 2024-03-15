setupDockerBuildx:
	docker buildx ls | grep codemotion-workshop &> /dev/null || \
		docker buildx create --use --name codemotion-workshop

packageJava:
	mvn install

dockerJava: packageJava setupDockerBuildx
	docker buildx build \
		--builder codemotion-workshop \
		--push \
		--platform linux/amd64,linux/arm64 \
		-t bitripa/springboot-sample-app:$(version) .

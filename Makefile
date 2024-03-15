setupDockerBuildx:
	docker buildx ls | grep codemotion-workshop &> /dev/null || \
		docker buildx create --use --name codemotion-workshop

packageJava:
	mvn -f ./java-springboot install

dockerJava: packageJava setupDockerBuildx
	docker buildx build \
		--builder codemotion-workshop \
		--push \
		--platform linux/amd64,linux/arm64 \
		-t bitripa/springboot-sample-app:$(version) ./java-springboot

packagePython:
	python3 -m venv python-flask/venv
	. python-flask/venv/bin/activate; pip install -r python-flask/requirements.txt

dockerPython: packagePython setupDockerBuildx
	docker buildx build \
		--builder codemotion-workshop \
		--push \
		--platform linux/amd64,linux/arm64 \
		-t bitripa/flask-sample-app:$(version) ./python-flask
#python:3.10-alpine not working -> https://github.com/open-telemetry/opentelemetry-operator/issues/1515
FROM python:3.12
WORKDIR /app
COPY . /app
RUN pip install -r requirements.txt
ENTRYPOINT ["python", "app.py"]

#python:3.10-alpine not working -> https://github.com/open-telemetry/opentelemetry-operator/issues/1515
FROM python:3.12
WORKDIR /app
COPY app.py /app
COPY requirements.txt /app
RUN pip install -r requirements.txt
#ENTRYPOINT ["flask", "run", "--host", "0.0.0.0", "-p", "8080"]
ENTRYPOINT ["python", "app.py"]

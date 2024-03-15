from flask import Flask, request
import logging

app = Flask(__name__)
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

@app.route("/health-check")
def health_check():
    logger.info("Feeling good!")
    return "OK"

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)

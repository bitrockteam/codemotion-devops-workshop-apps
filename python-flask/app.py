import os
from random import randint
from flask import Flask, request
import logging

asd = logging.getLogger("werkzeug")
asd.setLevel(logging.INFO)
app = Flask(__name__)
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

# TODO disable http log
@app.route("/rolldice")
def roll_dice():
    player = request.args.get('player', default = None, type = str)
    result = str(roll())
    print(str(logger))
    print(str(logging.getLogger("werkzeug")))
    if player:
        logger.info("%s is rolling the dice: %s", player, result)
    else:
        logger.info("Anonymous player is rolling the dice: %s", result)
    return result

@app.route("/checkStorage")
def check_storage():
    logger.info("Checking resources")
    return "OK"

def roll():
    return randint(1, 6)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)

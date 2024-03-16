import express, { Express } from 'express';
import expressWinston from 'express-winston';
import winston from "winston";
import logger from "./logger";

const loggerHandler = expressWinston.logger({
    transports: [
        new winston.transports.Console()
    ],
    format: winston.format.json(),
    meta: true,
    msg: "HTTP {{req.method}} {{req.url}}",
    expressFormat: true,
    colorize: false,
    ignoreRoute: function (req, res) { return false; }
})

const PORT: number = parseInt(process.env.PORT || '8080');
const HOSTNAME: string = process.env.HOSTNAME || "0.0.0.0"
const app: Express = express();
app.use(loggerHandler);

app.get('/health', (req, res) => {
    res.send("Feeling good")
});

app.get('/check-storage', (req, res) => {
    logger.info("Checking storage for order")
    const result = Math.random()
    if (result > 0.9) {
        return res.status(500).send("Unexpected error")
    } else if (result > 0.75) {
        return res.status(400).send("Missing supplies")
    } else {
        return res.send("OK")
    }
});

app.listen(PORT, HOSTNAME,() => {
    console.log(`Listening for requests on http://${HOSTNAME}:${PORT}`);
});

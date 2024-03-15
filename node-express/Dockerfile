FROM node:20-alpine
WORKDIR /app
COPY app.ts /app
COPY package.json /app
COPY package-lock.json /app
COPY tsconfig.json /app
RUN npm install
ENTRYPOINT ["npx", "ts-node", "app.ts"]

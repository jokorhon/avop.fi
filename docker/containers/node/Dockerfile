FROM node:4.2.6

MAINTAINER Oscar Perez  <oscar.perez@gofore.com>

RUN mkdir /src

WORKDIR /src

ADD app/package.json /src/package.json

RUN npm install

# replace this with your application's default port
EXPOSE 3000

CMD npm start

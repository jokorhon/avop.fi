FROM node:5.5

MAINTAINER Oscar Perez  <oscar.perez@gofore.com>

# Create new directory for holding code
RUN mkdir /src

# Change to code directory
WORKDIR /src

# use changes to package.json to force Docker not to use the cache
# when we change our application's nodejs dependencies:
ADD package.json /src/package.json

RUN npm install

EXPOSE 8000

# Use volumes if they actually work
ADD . /src

#CMD ["node", "server.js"]
CMD npm start


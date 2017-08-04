FROM node
RUN yarn config set registry https://registry.npm.taobao.org 
#issue: https://github.com/yarnpkg/yarn/pull/3240
# RUN yarn global add node-gyp

# More Env: https://github.com/parse-community/parse-server/blob/master/src/cli/definitions/parse-server.js
ENV PARSE_SERVER_APP_NAME ""
ENV PARSE_SERVER_APPLICATION_ID ""
ENV PARSE_SERVER_MASTER_KEY ""
ENV PORT ""
ENV PARSE_SERVER_HOST ""
ENV PARSE_SERVER_DATABASE_URI ""
ENV PARSE_SERVER_URL ""

WORKDIR /parse
COPY package.json /parse
COPY yarn.lock /parse
RUN yarn install
COPY public /parse/public
COPY config.json /parse
COPY cloud /parse/cloud
CMD yarn start






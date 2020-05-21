FROM node:10-slim

RUN npm i -g raml2html@7.2.0
RUN npm i -g raml2html-markdown-theme@1.0.2

WORKDIR /application

ENTRYPOINT ["raml2html"]

CMD ["-h"]

FROM node:12.16.2-stretch

#COPY ./project /project
#RUN cd /project && npm install

 

WORKDIR /application
COPY ./entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh && mkdir /render && chmod -R 777 /render && mkdir /compare && cd /compare && git init && chmod -R 777 /compare

ENTRYPOINT /entrypoint.sh
WORKDIR /project
CMD ["-h"]

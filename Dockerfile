FROM spredfast/dandy-java8:latest
MAINTAINER psg@spredfast.com
ENV HOME /root
USER root

RUN mkdir -p /opt/next-gen-api/conf

COPY deploy/docker/config /opt/next-gen-api/conf
COPY server/src/main/resources/config/config.yml /opt/next-gen-api/conf/dev-config.yml
COPY deploy/docker/service /etc/service
COPY server/build/libs/next-gen-api-shadow.jar /opt/next-gen-api

EXPOSE 8080
CMD /etc/service/next-gen-api/run.sh

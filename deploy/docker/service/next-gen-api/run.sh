#!/usr/bin/env bash

consul-template -consul="infra-consul.sf-ops.net:8500" -template="/opt/next-gen-api/conf/config.yml.ctmpl:/opt/next-gen-api/conf/config.yml" -once

source /scripts/newrelic-init.sh

java -Xmx256M \
    ${NEW_RELIC_JAVA_OPTS} \
    -cp /opt/next-gen-api/deploy:/opt/next-gen-api/next-gen-api-shadow.jar \
    com.spredfast.nextgenapi.dropwizard.NextGenApiServer server /opt/next-gen-api/conf/config.yml

#!/bin/sh
./gradlew clean build shadowJar
mv build/libs/keycloak-2fa-authenticator-all.jar build/libs/agosh-keycloak-2fa-all.jar
docker cp build/libs/agosh-keycloak-2fa-all.jar local_keycloak:/opt/jboss/keycloak/standalone/deployments/
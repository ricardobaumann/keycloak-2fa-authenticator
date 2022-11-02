https://gruchalski.com/posts/2020-09-03-keycloak-with-docker-compose/

docker cp build/libs/agosh-keycloak-2fa-all.jar local_keycloak:/opt/jboss/keycloak/standalone/deployments/

docker exec local_keycloak \
/opt/jboss/keycloak/bin/add-user-keycloak.sh \
-u admin \
-p admin \
&& docker restart local_keycloak

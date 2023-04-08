#FROM jboss/keycloak:16.1.1
FROM jboss/keycloak:latest

RUN mkdir /opt/jboss/keycloak/themes/mocktender-dev
COPY ./themes/mocktender-dev/ /opt/jboss/keycloak/themes/mocktender-dev/

EXPOSE 9280
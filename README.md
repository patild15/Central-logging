# central-logging
POC project for centralised logging system

This is spring boot application with three modules
central-logging-core is java jar which gives the core functionality of creating log-objects

central-logging-service is a spring boot service which has publised api to save logs and fetch logs from database. It has dependency of central-logging-core

central-logging-client is spring boot webservice based client application which uses central-logging-core as dependency and creates log object before sending it to central-logging-service using a util class - LogSender.java

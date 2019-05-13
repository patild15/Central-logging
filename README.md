# central-logging
POC project for centralised logging system

This is spring boot application with three modules
central-logging-core is java jar which gives the core functionality of creating log-objects

central-logging-service is a spring boot service which has publised api to save logs and fetch logs from database. It has dependency of central-logging-core

central-logging-client is spring boot webservice based client application which uses central-logging-core as dependency and creates log object before sending it to central-logging-service using a util class - LogSender.java


# Steps to run
First run the maven build and run central-logging-service as spring boot application

Second to test the services build & run central-logging-client

For testing following endpoints are available for client:

http://localhost:9090/log/mock/login/{user-id}/success?emailId={email}
http://localhost:9090/log/mock/login/{user-id}/fail?emailId={email}&errorMessage={someErrorMessage}
http://localhost:9090/log/mock/changepassword/{user-id}/success?emailId={email}
http://localhost:9090/log/mock/changepassword/{user-id}/fail?emailId={email}&errorMessage={someErrorMessage}
http://localhost:9090/log/mock/email/{user-id}/success?fromEmail={email}&toEmail={email}&subject=Test%20Subject
http://localhost:9090/log/mock/email/{user-id}/fail?fromEmail={email}&toEmail={email}&subject={subject}
http://localhost:9090/log/mock/error?errorCode={errorcode}&errorMessage={someErrorMessage}

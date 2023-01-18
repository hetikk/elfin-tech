Camunda schema: `src/main/resources/process.bpmn`  

Run command `make start-all` to start project.   
Open http://localhost:8080 (`demo` / `demo`)  
Sent request:
```
curl --location --request POST 'localhost:8080/engine-rest/process-definition/key/registration-process/start' \
--header 'Content-Type: application/json' \
--data-raw '{
    "variables": {
        "email": {
            "value": "EMAIL_TO_REGISTRATION",
            "type": "String"
        }
    }
}'
```




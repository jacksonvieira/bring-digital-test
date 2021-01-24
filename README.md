### Service Bring Digital

This project contains a simple basic business logic related to get transactions from apisandbox.

This project contains a Spring MVC Application.

### Rerequisities and Dependencies

- Java 8;
- Apache Commons Lang;
- Apache HTTP Client;


### Executing Unit Tests
The unit tests of the service can be executed with the following Maven command

```mvn clean install -Punit-tests```

### Features


- [X] Get all Transactions
- [X] Get transactions by type


> ### Examples

#### GET 
- hhttp://localhost:8080/BringTest/transaction/SEPA
- http://localhost:8080/BringTest/transaction


### The API methods that can be invoked

- GET /transaction - find all transactions;
- GET /transaction/{type} - find transactions by type;

### How to use

Configure the file application.properties with de url apisandbox, ex:
```bring.api.url=https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions```





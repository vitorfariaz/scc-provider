# Spring Cloud Contract - Provider Side
This project contains an api and the contract to the resources, so that consumers can consume this contract
and always stay updated if there is any update in the API, without the necessity of make a request to the infrastructure/API in the test environment,
 make easier/fast to test <br />

## About the project
This api has 2 resources, it is very lean because we focus on what matters: the definition and use of the contract. <br />
The consumer of the contract provided by this project is [Here]( https://github.com/vitorfariaz/scc-consumer). <br />
All we need to do to generate these contracts, after we built the API, is to specify them in ``test/resources/contracts``

## Resources
#### GET: /guests
Return a list of objects of type Guest <br />
Example of response: <br />
```
[
    {
        "name": "vitinho2",
        "email": "email@vitinho",
        "phone": 5544332233,
        "age": 20,
        "birthDate": "2020-09-15",
        "address": {
            "street": "bakerStreet",
            "houseNumber": 123
        }
    }
]
```

When starting the application you will not have any Guest registered, for that, you can use the resource ```/publish```  below. <br />

#### POST: /publish/{guestName} 
Publish a message on a Kafka topic and register a Guest in memory, which can be consulted in the resource above ```/guests``` <br />
Returns the registered Guest if it is successfully registered. <br />

Request Example: <br />
POST: /publish/Kevin <br />

Response Example: <br />
```
HTTP STATUS : 201 CREATED
{
    "name": "Kevin",
    "email": "email@vitinho",
    "phone": 5544332233,
    "age": 20,
    "birthDate": "2020-09-15",
    "address": {
        "street": "bakerStreet",
        "houseNumber": 123
    }
}
```

# To initialize
You must have:
- An IDE
- Java JDK 11 installed
- Maven

After that, follow the steps
- Just clone ```git clone https://github.com/vitorfariaz/scc-provider.git ``` or download the project and open in your IDE.
- Now, you have to run this command inside the project ```mvn clean install```
    - In this moment, you will see that have passed 2 tests, but how? The project don't have any tests declared...
      The spring cloud contract auto generate tests validating the contracts that we have defined in ```src/test/resources/contracts```
    - In these project we have the contracts defined for our API and for our kafka Topics <br />


If everything goes with success till here, the spring cloud contract verifier should have generated some artifacts in your target

**The auto generated tests** <br />
```target/generated-test-sources/contract/br.com.springContract.springcloudverifier/ContractVerifierTest``` <br />

**The stubs for the services contracts** <br />
```target/stubs/META-INF/br.com.springContract/spring-cloud-verifier-provider/0.02-SNAPSHOT/mappings``` <br />
```target/spring-cloud-verifier-provider-0.02-SNAPSHOT-stubs.jar``` <br />



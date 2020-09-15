# POC Spring Cloud Contract - Provider Side
This project contains the provider side of an api. It determines the contract so that consumers can consume this contract and always stay updated if there is any update in the provider application

## About the project
This api has 2 resources, it is very lean because was done to be able to focus on what matters: the definition and use of the contract.
To understrand the full example of this poc, is need to download the [consumer-side]( https://github.com/vitorfariaz/scc-consumer) that consumes the contract that is provide by this project, but this project can be run a part.


## Resources
**GET:** /allGuests
Return a list of objects of type Guest
Example of response:
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

When starting the application you will not have any Guest registered, for that, you can use the resource ```/publish```  below.


**POST**: /publish/{guestName}
Publish a message on a Kafka topic and register a Guest in memory, which can be consulted in the resource above ```/allGuests```
Note: we think it simpler to create the Guest object through the api and only allow the user to pass the guestName instead of passing the entire Guest object in the request body.

Returns the registered Guest if it is successfully registered.

Request Example:
POST: /publish/Kevin

Response Exemple:
```
HTTP STATUS : 201 CREATED
{
    "name": "vitinho6",
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
- Now, you have to run this commando inside the project ```mvn clean install```
    - In this moment, you will see that have passed 2 tests, but how? The project don't have any tests declared...  The spring cloud contract auto generate tests only with contracts defined in ```src/test/resources/contracts```

If everything goes with success till here,  the spring cloud contract verifier should have generated some artifacts in your target

**The auto generated tests**
```target/generated-test-sources/contract/br.com.springContract.springcloudverifier/ContractVerifierTest```

**The stubs for the services contracts**
```target/stubs/META-INF/br.com.springContract/spring-cloud-verifier-provider/0.02-SNAPSHOT/mappings``` <br />
```target/spring-cloud-verifier-provider-0.02-SNAPSHOT-stubs.jar```






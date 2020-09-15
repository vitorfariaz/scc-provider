import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("publish_kafka")
    input {
        triggeredBy("publishMessage()")
    }
    outputMessage {
        sentTo("v13jy9uz-default")
        body(
                [
                    name: "Vitor",
                    email: "vitinho@test.com",
                    phone: $(regex('[0-9]{8,9}')),
                    age: $(anyPositiveInt()),
                    birthDate: $(anyDate()),
                    address: [
                        street: $(regex('.{1,50}')),
                        houseNumber: $(anyPositiveInt())
                    ]
                ]
        )
    }
}
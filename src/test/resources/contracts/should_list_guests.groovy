import org.springframework.cloud.contract.spec.Contract

Contract.make{

    request {
        method 'GET'
        url '/allGuests'
    }

    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
              [
                  name: "Vitor",
                  email: "vitinho@test.com",
                  phone: $(regex('[0-9]{9}')),
                  age: "13"
              ],
              [
                  name: "Vitor2",
                  email: "vitinho2@test.com",
                  phone: $(regex('[0-9]{9}')),
                  age: "11"
              ]
        ]
        )
    }
}
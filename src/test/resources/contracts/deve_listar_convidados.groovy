import org.springframework.cloud.contract.spec.Contract

Contract.make{

    request {
        method 'GET'
        url '/todosConvidados'
    }

    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body([
              [
                  nome: "Vitor",
                  email: "vitinho@test.com",
                  telefone: $(regex('[0-9]{9}')),
                  idade: "13"
              ],
              [
                  nome: "Vitor2",
                  email: "vitinho2@test.com",
                  telefone: $(regex('[0-9]{9}')),
                  idade: "11"
              ]
        ]
        )
    }
}
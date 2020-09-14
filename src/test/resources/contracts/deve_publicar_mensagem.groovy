import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("publicacao_kafka")
    input {
        triggeredBy("publicarMensagem()")
    }
    outputMessage {
        sentTo("v13jy9uz-default")
        body(
                [
                    nome: "Vitor",
                    email: "vitinho@test.com",
                    telefone: $(regex('[0-9]{8,9}')),
                    idade: $(regex('[0-9]{1,3}')),
                    dataNascimento: $(anyDate()),
                    endereco: [
                        rua: $(regex('.{1,50}')),
                        numeroCasa: $(regex('[0-9]{1,6}'))
                    ]
                ]
        )
    }
}
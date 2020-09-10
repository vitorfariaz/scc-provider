import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("publicacao_kafka")
    input {
        triggeredBy("publicarMensagem()")
    }
    outputMessage {
        sentTo("topic1")
        body([
                foo: "example"
        ])
    }
}
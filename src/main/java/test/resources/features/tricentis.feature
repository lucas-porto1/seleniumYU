#language: pt

Funcionalidade: Validar Seguro de automóvel

  Cenário: Preenchendo dados do veículo
    Dado que estou na página de verificação de seguro
    Quando eu preencho o formulário de informações do veículo
    E preencho o formulário de informações do seguro
    E preencho o formulário de informações do produto
    E seleciono o valor do produto
    E envio um comentário
    Então eu recebo a mensagem de confirmação
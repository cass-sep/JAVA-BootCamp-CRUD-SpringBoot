# Uma API de troca de mensagens


São duas entidades para interagir: Seus _contatos_ e suas _conversas_.

Você pode **adicionar** contatos e então **conversar** com eles. Também pode **editar** e **excluir** qualquer um deles.

Além de **ver** toda as mensagens que trocou com alguém, você pode **mandar** novas, **editá-las** e **excluí-las**.

As consultas para essa _API_ são:

1. Uma listagem de todos os seus contatos.

2. Uma listagem de contatos que conversaram com você.

3. E a troca de mensagens com esse contato.

### _Para usar a API_:
É necessária a criação do seu contato para enviar as mensagens. E então os das pessoas com quem ira conversar.

Contatos:

- Para **criar** um contato faça uma requisição ``POST`` para ``localhost:8080/contatos``. Enviando o nome do contato no corpo da requisição;
![post-contato](/assets/post-contato.png)

- Para **consultar** todos os seus contatos faça uma requisição ``GET`` para ``localhost:8080/contatos``;

- Para **editar** ou **excluir** algum contato envie as requisições ``PUT`` ou ``DELETE`` passando o id do contato como parâmetro para ``localhost:8080/contatos/id``;
![put-contato](/assets/put-contato.png)

Com o(s) contatos(s) criados você já pode enviar mensagens.

Conversas:
- Para **enviar** uma mensagem escreva ela no corpo da requisição ``POST`` na chave ``"msg"``. Também no corpo coloque a chave ``"contato"`` para indicar o id do contato que receberá a mensagem. E por último a chave ``"enviou"`` pra indicar quem enviou a mensagem. Então faça a requisição  para ``localhost:8080/contatos``.
![post-conversa](/assets/post-conversa.png)

- Uma requisição ``GET`` para ``localhost:8080/conversas`` te devolverá uma **lista** com todos os contatos que já conversaram com você.

- Para **visualizar** as mensagens trocadas com um de seus contatos faça a requisição ``GET`` com o id do contato para ``localhost:8080/conversas/id``.

- Para **editar** alguma mensagem altere o valor da chave ``"msg"`` e envie a requisição ``PUT`` com o id da mensagem que você quer mudar como parâmetro para ``localhost:8080/conversas/id``. A mesma rota é usada na requisição ``DELETE`` se você pretender **excluir** a mensagem.
![put-conversa](/assets/put-conversa.png)
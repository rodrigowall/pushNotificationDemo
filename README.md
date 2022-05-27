# Getting Started pushNotificationDemo
Projeto desenvolvido com Spring Boot e Web APIs HTML5 Notifications para envio de mensagens únicas.

Após subir o projeto utlize o caminho abaixo para conectar no endpoint, troque {id} pelo numero (posteriormente utilizando o id identificador do seu usuário)

http://localhost:8080/index.html?id={id}

exemplo:
http://localhost:8080/index.html?id=1

Mostrará a página html que possui js para registrar na fonte do evento.

Em outra página ou aba do navegador acesse a url abaixo trocando {id} pelo identificador do usuáiro e {msg} pela notificação a ser enviada

http://localhost:8080/api/producer/test/{id}/{msg}

exemplo:

http://localhost:8080/api/producer/test/1/hello%20world

Será enviada a notificação "hello world"



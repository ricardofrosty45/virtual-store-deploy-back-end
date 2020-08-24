OBSERVATION: THIS README WILL BE IN ENGLISH AND PORTUGUESE! 

DOCKER - HOW CAN I RUN THIS API?
Hello! Soo first of all, you have to build this project to get the .jar of the API.
But, since a lot of people does not have maven on their computers i commited the target
soo you can run the jar!

Ola! Primeiramente, o certo é o usuario buildar este projeto para poder gerar o .jar
e assim executar o docker! mas, vendo que alguns não tem uma IDE na mão ou o maven instalado
eu comitei a pasta target junto com um build ja feito para poder rodar o comando do docker!

Recommendations:
You gotta install Docker soo you can run this command
install java too

Recomendações:
- Precisas ter o Docker instalado na sua maquina para poder rodar este comando
- e claro precisa ter o java tambem

- Command:
Open your cmd in the paste that contains the docker file and run this command
- $ docker build -t springio/gs-spring-boot-docker
- $ docker run -p 8080:8080 springio/gs-spring-boot-docker

- Comando:
Abra seu cmd na pasta onde contem o docker file e rode esse comando
- $ docker build -t springio/gs-spring-boot-docker
- $ docker run -p 8080:8080 springio/gs-spring-boot-docker



- VIRTUAL-STORE-PROJECT

This project was a challege soo i've made a api using Java 11 / Spring boot / Mongodb / Docker
and the front end i used React js and firebase to make the auths but it's not done yet (front end)

Este projeto foi um desafio, então eu desenvolvi esta api usando java 11 / Spring Boot / Mongo Db / Docker
junto com um front end que ainda nao esta integrado com o nosso back que seria com React js e firebase para os authentications

o front end foi um bonus para poder aplicar em alguma interface e poder consumir os meus endpoints

Segue o link do front end: https://happy-einstein-f483eb.netlify.app/


the deploy was made in heroku! here is the endpoints

https://virtual-store-project-back-end.herokuapp.com

os deploys do back foram feitos no heroku! 

Controllers / Endpoints

- User Endpoints

- Post Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (CREATES USER)
- Put Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (UPDATES USER)
- Delete Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (DELETES USER)
- Get Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (GETS USER BY ID)


- Post Method = https://virtual-store-project-back-end.herokuapp.com/v1/product (CREATE A NEW PRODUCT)
- Delete Method = https://virtual-store-project-back-end.herokuapp.com/v1/product (DELETES THE PRODUCT)
- Put Method = https://virtual-store-project-back-end.herokuapp.com/v1/product/update (UPDATES THE PRODUCT)
- Post Method = https://virtual-store-project-back-end.herokuapp.com/v1/product/buy (BUYS A PRODUCT)


- REQUESTS
i will be writing down the jsons used to eatch endpoint that i've wrote it !

- https://virtual-store-project-back-end.herokuapp.com/v1/user (GETS USER BY ID)
- JSON:
{
  "id": "string"
}

- Get Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (GETS USER BY ID)
- JSON:
{
  "id": "string"
}

- Put Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (UPDATES USER)
- JSON
{
  "birthDate": "dd-MM-yyyy",
  "id": "string",
  "name": "string"
}

- Post Method = https://virtual-store-project-back-end.herokuapp.com/v1/user (CREATES USER)
- JSON:
{
  "birthDate": "dd-MM-yyyy",
  "documentNumber": "string",
  "email": "string",
  "name": "string",
  "userAdresses": [
    {
    
      "streetName": "string",
      "zipCode": "string"
    }
  ]
}

- Product Controller 

Post Method = https://virtual-store-project-back-end.herokuapp.com/v1/product (CREATE A NEW PRODUCT)
- JSON:
{
  "createdProductDate": "2020-08-24T01:33:36.406Z",
  "productDescription": "string",
  "productName": "string",
  "productValue": 0,
  "statusProduct": "SOLD"
}


Delete Method = https://virtual-store-project-back-end.herokuapp.com/v1/product (DELETES THE PRODUCT)
- JSON:
{
  "productId": "string"
}

Put Method = https://virtual-store-project-back-end.herokuapp.com/v1/product/update (UPDATES THE PRODUCT)
- JSON:
{
  "idProduct": "string"
}


Post Method = https://virtual-store-project-back-end.herokuapp.com/v1/product/buy (BUYS A PRODUCT)
- JSON:
{
  "idProduct": "string",
  "productDescription": "string",
  "productName": "string",
  "productValue": 0
}

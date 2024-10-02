<div align="left">
  <h1><strong>Send Book Email using Spring Batch</strong></h1>
</div>

## Index

- [About](#about)
- [Complete challenge documentation](#documentação-completa-desafio)
- [How to execute the project](#como-executar-o-projeto)
- [Used Technologies](#tecnologias-utilizadas)
- [How to contribute](#como-contribuir)

## About

Summary
In summary, this project is a Spring Batch application that periodically checks for users with book loans nearing their return date and sends them email notifications using SendGrid. The job is scheduled using Quartz, and the batch job consists of reading user data, processing it to create email notifications, and sending those emails.

## Support Material

Access the link: [Support Material](https://drive.google.com/drive/folders/108SAajQwsMlliK6gNmWr3WnAcbf0eu0o)

[Return to Index](#index)

## How to execute the project

1. Clone the project from GitHub

   ````https://github.com/felipeam10/send-book-email-spring-batch````

2. In your preference IDE, open the project from the directory it was cloned to. 

3. Have the docker container installed on your computer. 

Before, locate the file in this project: ````\send-book-email-spring-batch\docker-compose.yml````

Climb structure:

``` 
docker-compose up -d
```

Stop structure:
```
docker-compose down
```
#### Data for connect to phpMyAdmin
- Server: mysql-docker
- User: root / user
- Password: 1234567

#### Data for connect to MySQL Workbench
- Host: 127.0.0.1
- Port: 3307
- User: root / user



[Return to Index](#index)


## Tecnologias Utilizadas

Antes de iniciar, assegure-se de ter o ambiente Java corretamente configurado em sua máquina. Abaixo você tem a relação das tecnologias que foram utilizadas no processo de desenvolvimento do projeto.

| Tecnologia                     | Versão                                     |
|--------------------------------|--------------------------------------------|
| Sistema Operacional            | Windows 10                                 |
| Linguagem de Programação (JDK) | java 17.0.7 2023-04-18 LTS                 
| Framework                      | Spring Boot 3.3.3                          |
| Banco de Dados                 | MySQL                                      |
| IDE                            | IntelliJ IDEA 2023.1.1 (Community Edition) |
| Container                      | Docker v4.24.2                             |

[Return to Index](#index)

## Contribuições 

Caso tenha uma contribuição que possa melhorar este projeto, por favor, abra uma issue ou um pull request, seguindo os passos abaixo.

1. Crie um 'Fork' do projeto
2. Crie uma 'Branch' para sua modificação (`git checkout -b feature/yourFeatureName`)
3. Faça o 'Commit' das suas mudanças (`git commit -m 'Add some yourFeatureName'`)
4. 'Push' para a 'Branch' (`git push origin feature/yourFeatureName`)
5. Abra uma 'Pull Request'

[Return to Index](#index)


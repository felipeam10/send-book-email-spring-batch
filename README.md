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

4. After to climb your Docker, access phpMyAdmin for manager your database: http://localhost:5050/index.php
5. Now, after you logged in database. You have create tables and populate her. The script for your database is in the file ````\send-book-email-spring-batch\import.sql```` 
6. In table ````tb_user```` alter the collumn ````email```` to your email to be received.
7. In table ````tb_user_book_loan```` alter the collumn ````loan_date```` to the current date you are in minus 06 days. Change at least one line.
8. Now you will configure the Send Grid Plattform, read the file ````SendGridDetails.txt```` in resource folder. I suffered a lot. I hope you don't suffer as much.
9. In class ````ProcessLoanNotificationEmailProcessorConfig.java```` and in the method ````process```` insert your email that was configurate in Send Grid for to send.
10. In class ````QuartzConfig.java```` and in the method ````jobTrigger```` configure the time for your job execution.


[Return to Index](#index)


## Technologies Used

Before starting, make sure you have the Java environment correctly configured on your machine. Below you have a list of the technologies that were used in the project development process.

| Technology                 | Version                                    |
|----------------------------|--------------------------------------------|
| Operating System           | Windows 10                                 |
| Programming Language (JDK) | java 17.0.7 2023-04-18 LTS                 
| Framework                  | Spring Boot 3.3.3                          |
| Database                   | MySQL                                      |
| IDE                        | IntelliJ IDEA 2023.1.1 (Community Edition) |
| Container                  | Docker v4.24.2                             |

[Return to Index](#index)

## Contributions

If you have a contribution that could improve this project, please open an issue or pull request by following the steps below.

1. Fork the project
2. Create a branch for your modification (`git checkout -b feature/yourFeatureName`)
3. Commit your changes (`git commit -m 'Add some yourFeatureName'`)
4. Push to the branch (`git push origin feature/yourFeatureName`)
5. Open a pull request

[Return to Index](#index)


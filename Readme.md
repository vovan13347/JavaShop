
[![Build Status](https://travis-ci.com/vovan13347/lab.svg?branch=main)](https://travis-ci.com/vovan13347/lab)

# *Технологии разработки программного обеспечения*
## *Лабораторная работа № 1: создание микросервиса на Spring Boot с базой данных*
### *Лебедев Владимир Владимирович ЗМАС2031*
## *Цель лабораторной работы:*
____
Знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).
Сооздание микросервиса, реализующего CRUD  на примере интернет магазина
### *Как запустить*
_Версия java - openjdk-11-jdk и СУБД PostgreSQL_
____

1. Загрузите проект из Github. Для клонирования репозитория необходимо выполнить команду:
`git clone https://github.com/vovan13347/JavaShop.git`

2. Необходимо встроить базу данных виртуальную среду . Установите [Docker Desktop](https://www.docker.com/products/docker-desktop) и запустите его

3. Для сборки приложения из командной строки с помощью maven, необходимо выполнить следующую команду из корневой директории проекта:
`mvn clean package spring-boot:repackage` или `mvn clean package`

4. В терминале Docker строим контейнер с нашим приложением  и запускаем  следующей командой:
`docker-compose up --build`, а чтобы остановить  используете команду `docker-compose down`

5. В терминале  запускаем приложение следующей командой: 
`mvn spring-boot:run`
____
### *Примеры CURL запросов:*

1. Получить список всех  пользователей:
`curl localhost:8080/api/myshop/users`

2. список товаров:
`curl localhost:8080/api/myshop/goods`

В ответ будет получен JSON ответ с информацией о всех пользователях которые имеются в БД.

3. поиск по id пользователя:

` curl localhost:8080/api/myshop/users/{id} `
В ответ будет получен JSON ответ с информацией о пользователе.

4. поиск по номеру id товара 
`curl localhost:8080/api/myshop/goods/{id}`


5. Получит значение hostname:
` curl localhost:8080/api/myshop/hostname` 
В ответ будет получен JSON в виде {hostname: "hostname"}.

____
### *Создание сервиса на Ubuntu-server:*

1. Создать файл сервиса командой:
`touch /etc/systemd/system/name_service.service`

2. Открыть файл сервиса командой:
`sudo nano /etc/systemd/system/name_service.service`


# name_service.service config
____
```
[Unit]
Description = описание сервиса
After=network.target

[Service]
User=root
Group=root
WorkingDirectory=/projects/lab/myshop
ExecStart=mvn spring-boot:run
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target

```

3. перезапустить daemon командой:
`sudo systemctl daemon-reload`

4. активировать сервис, позволить ему стартовать во время запуска системы:
`sudo systemctl enable name_service.service`

5. запустить службу командой:
`sudo systemctl start name_service.service`

6. остановить активную службу:
`sudo systemctl stop name_service.service`

7. отключить автозапуск службы:
`sudo systemctl disable name_service.service`
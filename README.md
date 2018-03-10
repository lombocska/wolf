<h1 align="center">
  <br>
  <img src="https://image.flaticon.com/icons/svg/714/714005.svg" alt="wolf" width="200">
  <br>
  WOLF
  <br>
</h1>

<h4 align="center">A smooth sea never made a skillful sailor.</h4>

<div align="center">
<!-- Build Status -->
  <a href="https://travis-ci.org/lombocska/wolf">
    <img src="https://travis-ci.org/lombocska/wolf.svg?branch=master"
      alt="Build Status" />
  </a>
  <!-- Codec codecoverage -->
  <a href="https://codecov.io/gh/lombocska/wolf">
    <img src="https://codecov.io/gh/lombocska/wolf/branch/master/graph/badge.svg" />
  </a>
</div>

<p align="center">
  <a href="#introduction">Introduction</a> •
  <a href="#used-technologies">Used Technologies</a> •
  <a href="#before-installing">Before Installing</a> •
  <a href="#prerequisites">Prerequisites</a> •
  <a href="#how-to-use-with-docker">How To Use With Docker</a> •
  <a href="#inspiration">Inspiration</a>
</p>

## Introduction

WOLF application provides a possible solution how to use SpringBoot(2.0.0.RELEASE) lightweight 
framework with Thymeleaf and STOMP WebSocket.


The home page lists all customers from the db.
Swagger UI shows all endpoints of app. As you can see, there are /save-customer endpoint. 
If you call this URL, the saved data appears immediately on /home page thanks for the WebSocket TCP connection.

![GIF](/documentation/resources/working.gif)


## Used technologies

#### backend

- [java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

- [maven](https://maven.apache.org/install.html)

- [spring boot](https://spring.io/)

- [WebSocket](https://spring.io/guides/gs/messaging-stomp-websocket/)

- [RabbitMQ](https://www.rabbitmq.com/)

#### database

- [postgreSQL](https://www.postgresql.org/)

#### frontend

- [thymeleaf](https://www.thymeleaf.org/)

#### devops

- [docker](https://www.docker.com/)


## Before Installing

If you want to try this app without cloning, then there are AWS instance with RDS postgresql database:

- open http://default-environment.sv3p8jifpb.us-east-2.elasticbeanstalk.com/home
- open http://default-environment.sv3p8jifpb.us-east-2.elasticbeanstalk.com/swagger-ui.html

Put the two tabs of your browser next to each other and in Swagger UI 
- call with some test data the /save-customer endpoint
- see what shows the /home tab.

```
Note: On http://default-environment.sv3p8jifpb.us-east-2.elasticbeanstalk.com/home screen
open your inspect window (Key F12) and on the console tab you can see the Websocket communication.

```

## Prerequisites

- jdk
- maven
- postgres
- (docker) //if you want to use this application with docker//


## How To Use With Docker

```bash
# Clone this repository
$ git clone https://github.com/lombocska/wolf.git
# Use docker potgres db
$ cd wolf-web/src/main/resources
  Use 'wolverine-database' (docker image name) as a host instead of 'wolf.cqus2hamenyz.us-east-2.rds.amazonaws.com'
# Wrap application into jar from command line
$ mvn clean install
# Build images and containers
$ docker-compose up -d
# Open the home page - go localhost:8080/home
```

## Inspiration

* **Spring IO** - *WebSocket* - [WebSocketGuide](https://spring.io/guides/gs/messaging-stomp-websocket/)
* **Testing** - *Controller testing* [SpringBoot App Tests](https://spring.io/guides/gs/testing-web/)
* **[MEMORYNOTFOUND](https://memorynotfound.com/)** - *Dealing with static resources* [Config Resources](https://memorynotfound.com/adding-static-resources-css-javascript-images-thymeleaf/)
* **[LOGO](https://www.flaticon.com/)** 

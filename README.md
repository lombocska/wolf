# WOLF

> A smooth sea never made a skillful sailor.


WOLF application provides a possible solution how to use SpringBoot(2.0.0.RELEASE) lightweight 
framework with Thymeleaf and STOMP WebSocket.

The home page lists all customers from the db.

![Home](/documentation/resources/home.png)

Swagger UI shows all endpoints of app. As you can see, there are /save-customer endpoint. 
If you call this URL, the saved data appears immediately on /home page thanks for the WebSocket TCP connection.

![Swagger UI](/documentation/resources/swagger-ui.png)


### Used technologies

#### backend

- [java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

- [maven](https://maven.apache.org/install.html)

- [spring boot](https://spring.io/)

#### database

- [postgreslq](https://www.postgresql.org/)

#### frontend

- [thymeleaf](https://www.thymeleaf.org/)


### Before Installing

If you want to try this app without cloning, then:

- open http://default-environment.sv3p8jifpb.us-east-2.elasticbeanstalk.com/home
- open http://default-environment.sv3p8jifpb.us-east-2.elasticbeanstalk.com/swagger-ui.html

Put the two tabs of your browser next to each other and in Swagger UI 
- call with some test data the /save-customer endpoint
- see what shows the /home tab.

```
Note: On http://default-environment.sv3p8jifpb.us-east-2.elasticbeanstalk.com/home screen
open your inspect window (Key F12) and on the console tab you can see the Websocket communication.

```

### Installing

1. `clone` this repo
2. `run` WolfApplication class with built-in tomcat 
3. `open` [link](https://localhost:8080/home) 

## Inspiration

* **Spring IO** - *WebSocket* - [WebSocketGuide](https://spring.io/guides/gs/messaging-stomp-websocket/)
* **Testing** - *Controller testing* [SpringBoot App Tests](https://spring.io/guides/gs/testing-web/)
* **[MEMORYNOTFOUND](https://memorynotfound.com/)** - *Dealing with static resources* [Config Resources](https://memorynotfound.com/adding-static-resources-css-javascript-images-thymeleaf/)

# Krace-demo

- Spring Boot with third-party tech demo, just for framework and tech practice
- 使用Spring Boot及第三方套件，做簡易範例，框架技術摸索、練習展示用

---

# Tech Stack / 技術棧

- Server Framework / 服務器端框架
  - Spring Boot
    - Target / 目標清單
      - mybatis
      - swagger
      - poi
      - spring-cloud-config
      - dom4j
      - redisson
    - Extra / 其他
      - Spring Security
      - JWT
      - Websocket
- Data Storage / 資料儲存體
  - Target / 目標清單
      - RocketMQ
      - Redis
      - MongoDB
      - MySQL

# Directory Structure / 目錄結構

```
project root / 專案根目錄
└───lib (third-party .jar) / 第三方資源庫
│
└───admin-server (spring boot project) / 服務器監控管理
│
└───main-demo (spring boot project as [spring-cloud-config-client, spring-admin-client]) / 主要範例專案，亦作為[spring-cloud-config-client, spring-admin-client]
│   │
│   └───docker (environment docker file, minimize to develop) / 其他服務環境，最小化部署，本地開發所使用
│   │   │
│   │   └───redis-cluster 
│   │   │
│   │   └───rocketmq
│   │
│   └───sql (mysql schema to init) / 初始化資料庫之結構SQL
│
└───rocket-demo-consumer (spring boot project) / RocketMQ生產者端
│
└───rocket-demo-producer (spring boot project) / RocketMQ消費者端
│
└───rocket-spring-boot (offer by apache official, only for module import) / 官方提供資源，作為模組匯入使用
│
└───spring-cloud-config-server (spring boot project) / 雲端設定檔服務端
```

# Tech Features / 實作項目列表

- Brief introduction
    - Basic CRUD and data model define
    - User login and register function
    - Simple message board function
    - Build Api Document by `Swagger`
    - Build simple unit-test for LoginController
    - Http session data write and read in `redis-cluster`
    - Check User session login status by interceptor
    - Custom error defined and handle with global and controller scope
    - Insert message to board via `RocketMQ` producer and consumer
    - Implement cloud config update and read via config server and remote `git` repository
    - Simple admin-server and admin-client function
    - Secure with JWT and user role privilege (spring-boot-security-jwt project)
    - Simple `Websocket` with `STOMP` implementation (spring-boot-websocket-example project)
- 簡述
    - 實作數據模型定義，和增刪查改
    - 使用者登入及註冊功能
    - 簡易留言板功能
    - 使用`Swagger`建立API文件
    - 撰寫登入控制器之單元測試
    - Http Session資料讀寫整合至`redis-cluster`
    - 使用攔截器來判斷使用者登入狀態
    - 自定義錯誤，全域、控制器區域之錯誤處理
    - 由`RocketMQ`生產者、消費者方式來處理留言板訊息插入至資料庫
    - 藉由遠端`git`倉儲庫來實作雲端設定檔參數更新及讀取
    - 簡易監控管理服務端和客戶端功能
    - 藉由JWT和角色權限實作資安防護 (在spring-boot-security-jwt專案中)
    - 簡易`Websocket`和`STOMP`實作 (在spring-boot-websocket-example專案中)

# Done / 已實作

- RESTful Api
    - Controller
    - RestController
        - Basic CRUD
            - ex: User register
- Data Model
    - MyBaits + Mysql
      - Entity code and `XML` document defined
        - ex: Entity `User` mapping with mysql table `users`
      - Entity association defined
        - ex: Entity `UserInfo` (one to one)
    - MongoDB - https://github.com/be3622436/spring-boot-security-jwt
      - ex: `UserRepository` implement by `MongoRepository`
- AOP
    - Interceptor
        - ex: Login session status check
- Error Handle
    - Exception custom defined
    - Controller level
        - `ControllerAdvice`, `ResponseEntityExceptionHandler`
    - Global level
        - `AbstractHandlerExceptionResolver`
            - ex: Raise `NotLoginAccessException` if user access without login
- Cache
    - Redis-Cluster
        - Redisson
            - ex: Simple get and set data
- Test
    - Unit-test
      - Login test without starting server
        - ex: `WebMvcTest`, `MockBean`
- Websocket - https://github.com/be3622436/spring-boot-websocket-example
  - communication by `STOMP`
- Message Queue
    - RocketMQ
        - Producer
            - ex: Produce simple message to Broker
        - Consumer
            - ex: Consume simple message from Broker
- Security - https://github.com/be3622436/spring-boot-security-jwt
    - Authentication implement by `spring-boot-starter-security` package
    - RESTful Authentication with JWT
- Environment
    - Docker containerize
        - Minimal RocketMQ `Nameserver` x 1, `Broker` x 1, `rmqconsole` monitor dashboard
        - Minimal Redis-Cluster `Node` x 3, `Replic` x 2 in every node

- Other
  - Spring-Boot-Admin
    - Simple admin-server and admin-client

# TODO / 待實作

- Topic
    - Test - build integrate-test
    - Other - poi, dom4j simple demo
- Deeper Research
    - Distributed and scalable microservice design
    - Data stable consistency and high availability
- Other
    - Spring framework core tech and concept study
    - Third-party package detailed functions study

- 主題
    - 建立單元、整合測試
    - 第三方套件簡易實作
- 深入探索
    - 分散式及高擴展性的微服務設計
    - 數據操作的一致性和高可用性
- 其他
    - Spring框架底層核心的技術及概念探索
    - 第三方套件的細節摸索

---
  

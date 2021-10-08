# Krace-demo

- Spring Boot with third-party tech demo
- 使用Spring Boot及第三方套件，做簡易範例，練習展示用

---

# Tech Stack / 技術棧

- Server Framework / 服務端框架
    - Spring Boot
        - mybatis
        - swagger
        - poi
        - spring-cloud-config
        - dom4j
        - redisson
- Data Storage / 資料儲存體
    - RocketMQ
    - Redis
    - MongoDB
    - MySQL

# Directory Structure / 目錄結構

```
project root / 專案根目錄
└───lib (third-party .jar) / 第三方資源庫
│
└───main-demo (spring boot project) / 主要範例專案
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

# Done / 已實作

- RESTful Api
    - Controller
    - RestController
        - Basic CRUD
            - ex: User account register
- Data Model
    - MyBaits + Mysql
        - ex: Entity `User` mapping with mysql table `users`
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
- Message Queue
    - RocketMQ
        - Producer
            - ex: Produce simple message to Broker
        - Consumer
            - ex: Consume simple message from Broker
- Environment
    - Docker containerize
        - Minimal RocketMQ `Nameserver` x 1, `Broker` x 1, `rmqconsole` monitor dashboard
        - Minimal Redis-Cluster `Node` x 3, `Replic` x 2 in every node

# TODO / 待實作

- Topic
    - MongoDB - implement a datasource
    - Test - build integrate-test
    - Other - poi, dom4j simple demo
- Deeper Research
    - Distributed and scalable microservice design
    - Data stable consistency and high availability
- Other
    - Spring framework tech and concept study
    - Third-party package detailed functions study

- 主題
    - 使用Swagger建立API文件
    - 實作MongoDB數據讀寫
    - 建立單元、整合測試
    - 第三方套件簡易實作
- 深入探索
    - 分散式及高擴展性的微服務設計
    - 數據操作的一致性和高可用性
- 其他
    - Spring框架的技術及概念研究
    - 第三方套件的細節摸索

---
  

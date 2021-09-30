# be3622436-demo
- spring boot with third-party tech demo
- 中文說明待後續補上
# Tech Stack
- Server Framework
  - Spring Boot
    - mybatis
    - swagger
    - poi
    - spring-cloud-config
    - dom4j
    - redisson
- Data Storage
  - RocketMQ
  - Redis
  - MongoDB
  - MySQL

# Directory Structure
```
project root
└───lib (third-party .jar)
│
└───main-demo (spring boot project)
│   │
│   └───docker (environment docker file, minimize to develop)
│   │   │
│   │   └───redis-cluster 
│   │   │
│   │   └───rocketmq
│   │
│   └───sql (mysql schema to init)
│
└───rocket-demo-consumer (spring boot project)
│
└───rocket-demo-producer (spring boot project)
│
└───rocket-spring-boot (offer by apache official, only for module import)
│
└───spring-cloud-config-server (spring boot project)
```

# Done:
- Restful Api
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

# Todo:
- Topic
  - Swagger - build Restful API Documents
  - MongoDB - implement a datasource
  - Test - build unittest, integrate-test
  - Other - poi, dom4j simple demo
- Deeper Research
  - Distributed and scalable microservice design
  - Data stable consistency and high availability 
- Other 
  - Third-party package detailed functions study

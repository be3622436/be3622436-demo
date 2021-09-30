# be3622436-demo
spring boot with third-party tech demo

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
project
└───lib (third-party .jar)
│
└───main-demo (spring boot project)
│   │
│   └───docker (environment docker file)
│       │
│       └───redis-cluster 
│       │
│       └───rocketmq
│   
└───rocket-demo-consumer (spring boot project)
│
└───rocket-demo-producer (spring boot project)
│
└───rocket-spring-boot (offer by apache offical, only for module import)
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
    - Minimal RocketMQ `Nameserver` x 1, `Broker` x 1, `rmqconsole`
    - Minimal Redis-Cluster `Node` * 3, `Replic` * 2 in every node

# TODO:
- redisson-mybatis-cache
https://github.com/redisson/redisson/tree/master/redisson-mybatis

# credit
简易信贷系统

# 服务分类：
1、该系统使用Springcloud搭建系统框架，系统主要分为业务服务、非业务服务、公用服务；三个主要模块
2、业务服务分为手机端服务、网页端服务、边缘服务；
3、非业务服务：eureka、admin、gateway、config、codegen（代码生成服务）、
4、公用服务：API服务


# 技术使用：
Springcloud家族组件（eureka、admin、gateway、config、hystrix、Feign、ribbon、zipkin等等）
mybatisplus、rabbitmq（系统解耦，可有可无）、Nginx、分布式事务LCN、ES、
docker、ELK、workflow、mycat

注意點：
1、整个系统在启动时，首先必须先启动config服务，在config服务启动成功后，再启动register服务，当register服务启动成功后，其他服务启动顺序随意

手机端：
user---auth---loan

网页端：
用户
借款
数据中心

所有user相关的信息都在user中，包括身份证、银行卡等等，都需要调用user模块

auth只执行认证，保存认证结果，loan需要调用user服务


loan需要调用user和auth服务
# sunfox

目录介绍

    sunfox  
        fox-config:9001       # spring cloud 配置中心    
        fox-discovery:8761    # spring cloud 注册中心   
        fox-framework  
            fox-framework-commons # 帮助类  建议每个项目都引用   
            fox-framework-mybatis # 操作数据库插件   
            fox-framework-swagger # api接口生成工具   
         
------------------------------------------------------------------------------------

RestAPI 推荐风格
 
     POST /account   ——新开一个账户  
     PUT  /account/customerId/close   ——注销一个已有的账户。  
     PUT  /account/customerId/debit   ——从账户里扣掉一些钱。  
     PUT  /account/customerId/credit  ——往账户里存入一些钱。  
     GET  /account/   ——通过账户 ID 加载相应的账户信息。  
     GET  /account/customerId/transactions  ——列出账户的交易历史。  
     GET  /accounts/query/customerId/  ——列出指定客户的所有账户。
     
     
---------------------------------------------------------------------------------------
  
         
 开发描述  
 1. 新建api项目 建立client (client.java , clientvo(入), clientpto(出)) 服务接口
 2. 建立服务端 controll (Controller impl  Client)  
 3. 使用工具生成 Mybatis gergentor 相关 model mapper(mapper.java mapper.xml) -- mvn mybatis-generator:generate   
 4. 复制配置文件更改配置文件名称 注意jar 包路径
 5. service 继承baseservice   impl继承 baseserviceimpl
 6. 注意controller 层配置文档 swagger      

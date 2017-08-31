# sunfox

目录介绍

    sunfox  
        fox-config       # spring cloud 配置中心    
        fox-discovery    # spring cloud 注册中心   
        fox-framework  
            fox-framework-commons # 帮助类  建议每个项目都引用   
            fox-framework-mybatis # 操作数据库插件   
            fox-framework-swagger # api接口生成工具   
            fox-framework-pay  # 第三方快捷支付 如微信，支付宝   
        fox-demo    
            fox-demo-api # 测试demoapi   
            fox-demo-server # 测试demoserver  服务
         
         
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
  
         
         

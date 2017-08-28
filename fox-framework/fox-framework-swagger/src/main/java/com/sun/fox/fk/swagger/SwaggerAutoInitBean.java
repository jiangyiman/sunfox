package com.sun.fox.fk.swagger;

import com.google.common.base.Predicate;
import com.sun.fox.fk.swagger.properties.SwaggerAutoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
@EnableConfigurationProperties(value = SwaggerAutoConfig.class)
@ConditionalOnProperty(name = "swagger.enabled")
public class SwaggerAutoInitBean {

    private static final Logger log = LoggerFactory.getLogger(SwaggerAutoInitBean.class);

    private static ApiInfo initDefualApiInfo( Map<String,String> info) {

       /* ApiInfo apiInfo = new ApiInfo(
                info.getTitle(),//大标题
                info.getDescription(),//描述
                info.getVersion(),//版本
                info.getTermsOfServiceUrl(),//服务条款URL
                new Contact(info.getName(), info.getUrl(), info.getEmail()),
                info.getLicense(),
                info.getLicenseUrl()
        );*/
        return null;
    }


    @Bean
    public List<Docket> restfulApi( SwaggerAutoConfig config ) {
        log.info("------------------------------------------");
        List<Docket> dockets = new ArrayList<>();
        // System.out.println("http://localhost:8080" + pathMapping + "/swagger-ui.html");
        if (!config.getDisGroup()) {
            // 不分组
            dockets.add(new Docket(DocumentationType.SWAGGER_2)
                    .groupName("Demo")
                    .useDefaultResponseMessages(true)
                    .forCodeGeneration(false)
                    //.pathMapping(pathMapping) // base，最终调用接口后会和paths拼接在一起
                    .select()
                    .paths(doFilteringRules())
                    .build()
                    .apiInfo(initDefualApiInfo(null)));
        } else {
            //分组
            System.out.println("---------------------------------");
        }
        return dockets;
    }


    /**
     * 设置过滤规则
     * 这里的过滤规则支持正则匹配
     *
     * @return
     */
    private Predicate<String> doFilteringRules() {
        return or(regex("/**"),
                regex("/hello.*"),
                regex("/vehicles.*")
        );
    }


}

package com.sun.fox.fk.swagger;

import com.google.common.base.Predicate;
import com.sun.fox.fk.swagger.properties.Defual;
import com.sun.fox.fk.swagger.properties.SwaggerAutoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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

@Configuration
@EnableConfigurationProperties(value = {SwaggerAutoConfig.class})
@ConditionalOnProperty(name = "swagger.enabled")
@EnableSwagger2
public class SwaggerAutoInitBean  implements BeanFactoryAware {

    private BeanFactory beanFactory;

    private static final Logger log = LoggerFactory.getLogger(SwaggerAutoInitBean.class);

    private static ApiInfo apiInfo = null;

    /**
     * 初始化默认配置
     *
     * @param info
     * @return
     */
    private static ApiInfo initDefualApiInfo( Defual info ) {
        apiInfo = new ApiInfo(
                info.getTitle(),//大标题
                info.getDescription(),//描述
                info.getVersion(),//版本
                info.getTermsOfServiceUrl(),//服务条款URL
                new Contact(info.getName(), info.getUrl(), info.getEmail()),
                info.getLicense(),
                info.getLicenseUrl());
        return apiInfo;
    }

    private ApiInfo setApiInfoInit( Defual info ) {

        return new ApiInfo(
                info.getTitle() != null ? info.getTitle() : apiInfo.getTitle(),//大标题
                info.getDescription() != null ? info.getDescription() : apiInfo.getDescription(),//描述
                info.getVersion() != null ? info.getVersion() : apiInfo.getVersion(),//版本
                info.getTermsOfServiceUrl() != null ? info.getTermsOfServiceUrl() : apiInfo.getTermsOfServiceUrl(),//服务条款URL
                new Contact(info.getName() != null ? info.getName() : apiInfo.getContact().getName(),
                        info.getUrl() != null ? info.getUrl() : apiInfo.getContact().getUrl(),
                        info.getEmail() != null ? info.getEmail() : apiInfo.getContact().getEmail()),
                info.getLicense() != null ? info.getLicense() : info.getLicense(),
                info.getLicenseUrl() != null ? info.getLicenseUrl() : apiInfo.getLicenseUrl());
    }

    @Bean
    @ConditionalOnMissingBean
    public List<Docket> docketsInitRestApi( SwaggerAutoConfig config ) {
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
        initDefualApiInfo(config.getDefual());
        List<Docket> dockets = new ArrayList<>();
        if (!config.getEngroup()) {
            // 不分组
            Docket docker = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(this.apiInfo)
                    .groupName(config.getDefual().getGroup())
                    .useDefaultResponseMessages(true)
                    .forCodeGeneration(false)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(
                            config.getDefual().getBasePackage() == null ?
                                    "com.sun.fox":config.getDefual().getBasePackage()))
                    .paths(PathSelectors.any())
                    .build();
            configurableBeanFactory.registerSingleton(config.getDefual().getGroup(),docker);
            dockets.add(docker);
        } else {
            //分组
            Map<String, Defual> map = config.getDocket();
            for (String key : map.keySet()) {
                Defual info = map.get(key);
                Docket docker = new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(setApiInfoInit(info))
                        .groupName(key)
                        .useDefaultResponseMessages(true)
                        .forCodeGeneration(false)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage(info.getBasePackage()))
                        .paths(PathSelectors.any())
                        .build();
                configurableBeanFactory.registerSingleton(key,docker);
                dockets.add(docker);
            }
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


    @Override
    public void setBeanFactory( BeanFactory beanFactory ) throws BeansException {
        this.beanFactory = beanFactory;
    }
}

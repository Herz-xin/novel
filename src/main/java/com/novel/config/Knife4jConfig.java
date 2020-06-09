package com.novel.config;

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

/**
 * Knife4j的配置文件
 * Description: <br/>
 * date: 2020/5/19 15:57<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {
    @Bean
    public Docket docket() {
        //确定其文档类型
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.novel.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("novel后台接口").description("novel的后台接口，暂时没有描述").termsOfServiceUrl("http://localhost:8080/")
                .contact(contact()).version("1.0").build();
    }

    private Contact contact() {
        Contact contact = new Contact("zuo","","1922056393@qq.com");
        return contact;
    }
}
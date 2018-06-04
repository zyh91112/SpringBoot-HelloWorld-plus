package com.example.spring_demo.config;

/**
 * @author yinghua
 * Created on 2018/5/29.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Swagger配置
 * 生成的api文档地址(HTML版)：http://localhost:8080/swagger-ui.html
 * 生成的api文档地址(JSON版)：http://localhost:8080/v2/api-docs
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("普通用户api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bnuz.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
//                .alternateTypeRules(
//                        typeResolver.resolve(DeferredResult.class),
//                        typeResolver.resolve(ResponseEntity.class, WildcardType.class),
//                        typeResolver.resolve(WildcardType.class))
                .useDefaultResponseMessages(false)
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .enableUrlTemplating(true)
//                .additionalModels(typeResolver.resolve(AdditionalModel.class))
                ;
    }

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理员api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bnuz.controller.admin"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
//                .alternateTypeRules(
//                        typeResolver.resolve(DeferredResult.class),
//                        typeResolver.resolve(ResponseEntity.class, WildcardType.class),
//                        typeResolver.resolve(WildcardType.class))
                .useDefaultResponseMessages(false)
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .enableUrlTemplating(true)
//                .additionalModels(typeResolver.resolve(AdditionalModel.class))
                ;
    }

//    @Autowired
//    private TypeResolver typeResolver;

    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("mykey", authorizationScopes));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("活动总台api文档")
//                .description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
//                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")
                .build();
    }

//    @Bean
//    UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//                .deepLinking(true)
//                .displayOperationId(false)
//                .defaultModelsExpandDepth(1)
//                .defaultModelExpandDepth(1)
//                .defaultModelRendering(ModelRendering.EXAMPLE)
//                .displayRequestDuration(false)
//                .docExpansion(DocExpansion.NONE)
//                .filter(false)
//                .maxDisplayedTags(null)
//                .operationsSorter(OperationsSorter.ALPHA)
//                .showExtensions(false)
//                .tagsSorter(TagsSorter.ALPHA)
//                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
//                .validatorUrl(null)
//                .build();
//    }
}
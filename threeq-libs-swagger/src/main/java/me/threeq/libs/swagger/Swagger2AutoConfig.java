package me.threeq.libs.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Date 16/5/31
 * @User three
 */
@Configuration
//@ConditionalOnProperty(name = "swagger2.base-package")
@EnableSwagger2
@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class,
        springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class Swagger2AutoConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TypeResolver typeResolver;

    @Value("${swagger2.base-package}")
    private String basePackage;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // Make Swagger meta-data available via <baseURL>/v2/api-docs/
        registry.addResourceHandler("/swagger-ui//**")
                .addResourceLocations("classpath:/META-INF/resources/");
        // Make Swagger UI available via <baseURL>/apis.html
        registry.addResourceHandler("/api-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)//<3>
                .select()//<4>
//                .apis(RequestHandlerSelectors.basePackage(basePackage))//<5>
                .paths(PathSelectors.any())//<6>
                .build()//<7>
                .apiInfo(apiInfo())
//                .pathMapping("/v2/api-docs.json")//<8>
////                .directModelSubstitute(LocalDate.class,
////                        String.class)//<9>
//                .genericModelSubstitutes(ResponseEntity.class)
//                .alternateTypeRules(
//                        newRule(typeResolver.resolve(DeferredResult.class,
//                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
//                                typeResolver.resolve(WildcardType.class)))//<10>
//                .useDefaultResponseMessages(false)//<11>
//                .globalResponseMessage(RequestMethod.GET,//<12>
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("500 message")
//                                .responseModel(new ModelRef("Error"))//<13>
//                                .build()))
//                .securitySchemes(newArrayList(apiKey()))//<14>
//                .securityContexts(newArrayList(securityContext()))//<15>
//                .enableUrlTemplating(true)//<21>
                .globalOperationParameters(//<22>
                        newArrayList(
                                new ParameterBuilder()
                                        .name("enterprise")
                                        .description("企业 domain")
                                        .modelRef(new ModelRef("string"))
                                        .parameterType("path")
                                        .required(true)
                                        .build(),
                                new ParameterBuilder()
                                        .name("app")
                                        .description("应用")
                                        .modelRef(new ModelRef("string"))
                                        .parameterType("path")
                                        .required(true)
                                        .build()
                                ))
                .produces(getAllProduceContentTypes())
                .consumes(getAllConsumeContentTypes())
//                .tags(new Tag("Pet Service", "All apis relating to pets")) // <25>
//                .additionalModels(typeResolver.resolve(AdditionalModel.class)) //<26>
                ;
    }

    private Set<String> getAllConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        // Add other media types if required in future
        consumes.add(MediaType.APPLICATION_JSON_UTF8_VALUE);
        return consumes;
    }

    private Set<String> getAllProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        // Add other media types if required in future
        produces.add(MediaType.APPLICATION_JSON_UTF8_VALUE);
        return produces;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "基础服务 REST API",
                "Some custom description of API.",
                "v1.0.0",
                "http://blog.threeq.me",
                new Contact("threeq", "http://blog.threeq.me", "threeq@foxmail.com"),
                "threeq @2017-2100",
                "http://blog.threeq.me",
                new ArrayList<>());
    }

    private ApiKey apiKey() {
        return new ApiKey("内部开发key", "api_key", "header");//<16>
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))//<17>
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("mykey", authorizationScopes));//<18>
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(//<19>
                "test-app-client-id",
                "test-app-client-secret",
                "test-app-realm",
                "test-app",
                "apiKey",
                ApiKeyVehicle.HEADER, //<23>
                "api_key", //<24>
                "," /*scope separator*/);
    }

//    @Bean
//    UiConfiguration uiConfig() {
//        return new UiConfiguration(//<20>
//                "validatorUrl",// url
//                "none",       // docExpansion          => none | list
//                "alpha",      // apiSorter             => alpha
//                "schema",     // defaultModelRendering => schema
//                UiConfiguration.DEFAULT.DEFAULT_SUBMIT_METHODS,
//                false,        // enableJsonEditor      => true | false
//                true);        // showRequestHeaders    => true | false
//    }
}

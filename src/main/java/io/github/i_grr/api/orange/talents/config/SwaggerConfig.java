package io.github.i_grr.api.orange.talents.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String API_BASE_PACKAGE = "io.github.i_grr";
    private static final String API_TITLE = "API Orange Talents";
    private static final String API_DESCRIPTION = "API REST para o controle de enderecos de usuarios";
    private static final String API_VERSION = "1.0.0";
    private static final String CONTACT_NAME = "Igor Pereira da Silva";
    private static final String CONTACT_GITHUB = "https://github.com/i-grr";
    private static final String CONTACT_EMAIL = "igorpereira120@gmail.com";

    @Bean
    public Docket orangeTalentsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(API_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }

}

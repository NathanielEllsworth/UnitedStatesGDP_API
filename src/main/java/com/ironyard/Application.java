package com.ironyard;

import com.ironyard.dto.USAGDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;



/**
 * Created by nathanielellsworth on 11/7/16.
 */

@EnableSwagger2
@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket UNnewsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("gdp")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/usagdp.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Annual US GDP growth (or shrink) with Swagger, SpringBoot, JPA via Hibernate")
                .description("Shows the annual percent change in Gross Domestic Product for the US.")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Nathaniel Ellsworth")
                .license("Apache License Version 2.1")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }


}

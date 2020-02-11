package dev.mentz.myorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource(value = "classpath:META-INF/v1_myorder.properties")
public class SwaggerConfig {
    // Swagger é um framework de documentação, ele gera
    // documentação baseado em anotações.
    // Vamos definir um ClassPath para que ele saiba onde
    // buscar as anotações para gerar a documentação.

//    BASE_PATH_APP é a variável que define o URL base do aplicativo
    private static final String BASE_PATH_APP = "/myorder";

//    BASE_PATH_REST define o URL do REST (da API)
    private static final String BASE_PATH_REST = "/api/";

//    BASE_PACKAGE define o caminho do pacote do aplicativo
    private static final String BASE_PACKAGE = "dev.mentz.myorder.api";

//    @Bean é bastante importante, mas não sabemos o porque ainda.
    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.mentz.myorder"))
                .paths(PathSelectors.any())
                .build();
    }
}

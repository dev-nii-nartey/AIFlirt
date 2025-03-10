package com.aiflirt;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ai flirt Service")
                        .version("1.0")
                        .description("This is the API doc for the Ai flirt  Service"));
    }
}

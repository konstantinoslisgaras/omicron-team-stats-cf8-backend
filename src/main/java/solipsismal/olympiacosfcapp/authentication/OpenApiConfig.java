package solipsismal.olympiacosfcapp.authentication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Olympiacos FC Unofficial App")
                        .version("1.0.0")
                        .description("Unofficial App for Olympiacos Players, Games and Statistics.")
                        .contact(new Contact()
                                .name("Konstantinos Lisgaras")
                                .email("konstantinoslisgaras@gmail.com"))
                        .license(new License()
                                .name("Educational project for AUEB - Coding Factory 2025.")
                                .url("https://github.com/konstantinoslisgaras/olympiacos-fc-unofficial-app")));
    }
}

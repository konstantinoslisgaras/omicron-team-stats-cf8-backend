package solipsismal.olympiacosfcapp.authentication;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",     // Must match @SecurityRequirement's name
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .info(new Info()
                        .title("Omicron Team Stats App")
                        .version("1.0.0")
                        .description("Unofficial App for Olympiacos Players, Games and Statistics.")
                        .contact(new Contact()
                                .name("Konstantinos Lisgaras")
                                .email("konstantinoslisgaras@gmail.com")
                                .url("https://github.com/konstantinoslisgaras/olympiacos-fc-unofficial-app"))
                        .license(new License()
                                .name("Educational project for AUEB - Coding Factory 2025.")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
package mx.uam.tsis.ejemplobackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringFoxConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mi primer API REST")
                        .description("Ejemplo de API del curso TSIS")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Humberto Cervantes")
                                .url("www.humbertocervantes.net")
                                .email("hcm@xanum.uam.mx"))
                        .license(new License()
                                .name("API License")
                                .url("API license URL")));
    }
}


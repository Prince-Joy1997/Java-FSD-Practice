package in.stackroute.ust;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Bean
    public OpenAPI openApi() {
        Contact contact = new Contact()
                .name("Prince Joy")
                .email("princeJoy@gmail.com")
                .url("http://stackroute,in");

        Info info = new Info()
                .version("1.0.0")
                .title("Todo Application Documentation")
                .contact(contact)
                .license(new License().name("GPL"))
                .description("Spring Open API Documentation with Data Rest JPA")
                .summary("""
                        A spring boot application that demonstrates the usage of rest
                        api documentation using spring doc, open api and swagger.
                        """);

        return new OpenAPI().info(info);
    }
}
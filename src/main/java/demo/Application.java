package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner init(CharacterRepository characterRepository) {
        return (evt) -> Arrays.asList(
                "mueller,meier,schulze".split(","))
                .forEach(
                        a -> {
                            characterRepository.save(new Character(a));
                        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

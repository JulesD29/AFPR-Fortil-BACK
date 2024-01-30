package group.fortil;

import group.fortil.entities.Tag;
import group.fortil.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;


@SpringBootApplication
@EntityScan("group.fortil.entities")
@EnableJpaRepositories("group.fortil.repository")
@EnableAutoConfiguration
public class Main implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private final String jpaUrl;
    private final Service1 service1;
    private final TagRepository tagRepository;

    // Constructeur
    public Main(
            @Autowired TagRepository tagRepository,
            @Value("${group.fortil.test}") String jpaUrl,
            @Autowired Service1 service1
            ){
        this.tagRepository = tagRepository;
        this.jpaUrl = jpaUrl;
        this.service1=service1;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        //Stream.of( context.getBeanDefinitionNames()).sorted().forEach(LOGGER::info);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(jpaUrl);
        service1.maMethode1();
    }

}
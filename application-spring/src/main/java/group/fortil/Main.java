package group.fortil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.text.ParseException;


@SpringBootApplication
@EnableAutoConfiguration
@Import({JpaConfiguration.class, BusinessConfiguration.class, ControllerConfiguration.class})
public class Main implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    //private final String jpaUrl;
    //private final Service1 service1;


    // Constructeur
    public Main() {
    }

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        //Stream.of( context.getBeanDefinitionNames()).sorted().forEach(LOGGER::info);
    }

    @Override
    public void run(String... args) throws Exception {
        //LOGGER.info(jpaUrl);
        //service1.maMethode1();
    }


}
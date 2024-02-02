package group.fortil;

import group.fortil.entities.Message;
import group.fortil.entities.Tag;
import group.fortil.entities.User;
import group.fortil.repository.MessageRepository;
import group.fortil.repository.TagRepository;
import group.fortil.repository.UserRepository;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
@EntityScan("group.fortil.entities")
@EnableJpaRepositories("group.fortil.repository")
@EnableAutoConfiguration
public class Main implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    //private final String jpaUrl;
    //private final Service1 service1;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    private static UserRepository userRepository;
    private static MessageRepository messageRepository;
    private static TagRepository tagRepository;


    // Constructeur
    public Main(
//            @Autowired Service1 service1,
            @Autowired UserRepository userRepository,
            @Autowired MessageRepository messageRepository,
            @Autowired TagRepository tagRepository
            ) {
        //this.jpaUrl = jpaUrl;
        //this.service1=service1;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.tagRepository = tagRepository;
    }

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        //Stream.of( context.getBeanDefinitionNames()).sorted().forEach(LOGGER::info);

        userRepository = context.getBean(UserRepository.class);
        messageRepository = context.getBean(MessageRepository.class);
        tagRepository = context.getBean(TagRepository.class);


        User myUser = new User(1L,"Jules", "Dupont", "oui@oui.bzh", "ouioui");
        userRepository.save(myUser);
        messageRepository.save(new Message(2L, "Salut c'est moi !", dateFormat.parse("25/01/2024 15:15:15"), dateFormat.parse("30/01/2024 16:16:16"), myUser));
        tagRepository.save(new Tag(3L, "#tag1"));
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @Override
    public void run(String... args) throws Exception {
        //LOGGER.info(jpaUrl);
        //service1.maMethode1();
    }

}
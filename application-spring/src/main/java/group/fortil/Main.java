package group.fortil;

import group.fortil.business.MessageBusiness;
import group.fortil.business.UserBusiness;
import group.fortil.controllers.UserController;
import group.fortil.entities.Message;
import group.fortil.entities.Tag;
import group.fortil.entities.User;
import group.fortil.repository.MessageRepository;
import group.fortil.repository.TagRepository;
import group.fortil.repository.UserRepository;
import group.fortil.service.MessageService;
import group.fortil.service.TagService;
import group.fortil.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@SpringBootApplication
@EntityScan("group.fortil.entities")
@EnableJpaRepositories("group.fortil.repository")
@EnableAutoConfiguration
public class Main implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    //private final String jpaUrl;
    //private final Service1 service1;


    private static UserRepository userRepository;
    private static MessageRepository messageRepository;
    private static TagRepository tagRepository;

    private static UserService userService;

    private static MessageService messageService;

    private static TagService tagService;


    // Constructeur
    public Main(
//            @Autowired Service1 service1,
//            @Autowired UserRepository userRepository,
//            @Autowired MessageRepository messageRepository,
//            @Autowired TagRepository tagRepository,
            @Autowired UserService userService,
            @Autowired MessageService messageService,
            @Autowired TagService tagService
            ) {
        //this.jpaUrl = jpaUrl;
        //this.service1=service1;

        this.userService=userService;
        this.messageService=messageService;
        this.tagService=tagService;
    }

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        //Stream.of( context.getBeanDefinitionNames()).sorted().forEach(LOGGER::info);

        userRepository = context.getBean(UserRepository.class);
        messageRepository = context.getBean(MessageRepository.class);
        tagRepository = context.getBean(TagRepository.class);



        // Init mydatabase
        //initDatabase();


        // Use of services #create
//        Optional<UserBusiness> userBusiness = userService.findById(5L);
//        userBusiness.ifPresent(userBusiness1 -> {
//            try {
//                newMessageFromBusiness("Coucou c'est moi le BusinessLayer", new Date()), userBusiness1);
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        });


        //Controller



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


    public static void initDatabase() throws ParseException {
        User myUser = new User("Benoît", "Decajou", "non@non.bzh", "nonnon");
        userRepository.save(myUser);
        messageRepository.save(new Message("Yo !", new Date(), myUser));
        tagRepository.save(new Tag("#tag2Beubeu"));
    }

    public static void newMessageFromBusiness(String message, Date creationDate, UserBusiness userBusiness) {
        MessageBusiness messageBusiness = new MessageBusiness();
        messageBusiness.setValue(message);
        messageBusiness.setCreation_date(creationDate);
        messageBusiness.setUser(userBusiness);
        messageService.create(messageBusiness);
    }

}
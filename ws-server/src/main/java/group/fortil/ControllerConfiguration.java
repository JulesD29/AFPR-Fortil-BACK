package group.fortil;

import group.fortil.authentification.ConfigAuthentification;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan
@Import(ConfigAuthentification.class)
public class ControllerConfiguration {

}

package group.fortil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class Service1Impl2 implements Service1 {

    final static Logger LOGGER = LoggerFactory.getLogger(Service1Impl2.class);


    @Override
    public void maMethode1() {
        LOGGER.info("INFO2");
    }
}

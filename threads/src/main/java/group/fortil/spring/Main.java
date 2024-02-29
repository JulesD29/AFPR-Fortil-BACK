package group.fortil.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Main implements CommandLineRunner {

    @Autowired
    private SyncService syncService;

    @Autowired
    private AsyncService asyncService;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //syncService.syncService1();
        //syncService.syncService2();
        syncService.syncService3();


        //asyncService.asyncService1();
        //asyncService.asyncService2();
        asyncService.asyncService3();
    }
}

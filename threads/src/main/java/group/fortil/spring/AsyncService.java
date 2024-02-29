package group.fortil.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private static final long THREAD_1_DURATION_SEC = 60;
    private static final long THREAD_2_DURATION_SEC = 5;

    @Async
    public void asyncService1() {
        System.out.println("Async Service 1 started");
        try {
            for (int i = 0; i < THREAD_1_DURATION_SEC; i++) {
                System.out.println("Async Service 1 in progress: " + (i + 1) + "/" + THREAD_1_DURATION_SEC + " seconds");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Async Service 1 finished");
    }

    @Async
    public void asyncService2() {
        System.out.println("Async Service 2 started");
        try {
            for (int i = 0; i < THREAD_2_DURATION_SEC; i++) {
                System.out.println("Async Service 2 in progress: " + (i + 1) + "/" + THREAD_2_DURATION_SEC + " seconds");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Async Service 2 finished");
    }

    @Async
    public void asyncService3() {
        System.out.println("Async Service 3 started");
        long startTime2 = System.currentTimeMillis();

        Thread service3_1Thread = new Thread(() -> {
            System.out.println("Async Service 3.1 started");
            asyncService1(); // Call asyncService1
            System.out.println("Async Service 3.1 finished");
        });
        service3_1Thread.start(); // Start Service 1

        // Launch 5 iterations of Service 2 asynchronously
        for (int i = 0; i < 5; i++) {
            asyncService2(); // Call asyncService2
        }

        // Wait for service 3.1 thread to finish
        try {
            service3_1Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Async Service 3 finished");
        long endTime2 = System.currentTimeMillis();
        System.out.println("Duration of AsyncServices: " + (endTime2 - startTime2) / 1000 + " seconds");

    }
}

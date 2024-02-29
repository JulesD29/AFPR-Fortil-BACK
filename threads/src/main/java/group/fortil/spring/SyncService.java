package group.fortil.spring;


import org.springframework.stereotype.Service;

@Service
public class SyncService {

    private static final long THREAD_1_DURATION_SEC = 60;
    private static final long THREAD_2_DURATION_SEC = 5;

    public void syncService1() {
        System.out.println("Sync Service 1 started");
        try {
            for (int i = 0; i < THREAD_1_DURATION_SEC; i++) {
                System.out.println("Sync Service 1 in progress: " + (i + 1) + "/" + THREAD_1_DURATION_SEC + " seconds");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync Service 1 finished");
    }

    public void syncService2() {
        System.out.println("Sync Service 2 started");
        try {
            for (int i = 0; i < THREAD_2_DURATION_SEC; i++) {
                System.out.println("Sync Service 2 in progress: " + (i + 1) + "/" + THREAD_2_DURATION_SEC + " seconds");
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync Service 2 finished");
    }

    public void syncService3() {
        System.out.println("Sync Service 3 started");
        long startTime = System.currentTimeMillis();
        try {
            Thread service3_1Thread = new Thread(() -> {
                System.out.println("Sync Service 3.1 started");
                try {
                    for (int i = 0; i < THREAD_1_DURATION_SEC; i++) {
                        System.out.println("Sync Service 3.1 in progress: " + (i + 1) + "/" + THREAD_1_DURATION_SEC + " seconds");
                        Thread.sleep(1000); // Sleep for 1 second
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sync Service 3.1 finished");
            });
            service3_1Thread.start(); // Start Service 1
            service3_1Thread.join(); // Wait for Service 1 to finish

            // Launch 5 iterations of Service 2
            for (int i = 0; i < 5; i++) {
                int finalI = i;
                Thread service3_2Thread = new Thread(() -> {
                    System.out.println("### Starting Service 3.2 iteration " + (finalI + 1) + " : ###");
                    System.out.println("Sync Service 3.2 started");
                    try {
                        for (int j = 0; j < THREAD_2_DURATION_SEC; j++) {
                            System.out.println("Sync Service 3.2 in progress: " + (j + 1) + "/" + THREAD_2_DURATION_SEC + " seconds");
                            Thread.sleep(1000); // Sleep for 1 second
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Sync Service 3.2 finished");
                });
                service3_2Thread.start(); // Start Service 2
                service3_2Thread.join(); // Wait for Service 2 to finish
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync Service 3 finished");
        long endTime = System.currentTimeMillis();
        System.out.println("Duration of SyncServices: " + (endTime - startTime) / 1000 + " seconds");

    }
}
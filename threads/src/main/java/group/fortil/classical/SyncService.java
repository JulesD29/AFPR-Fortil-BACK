package group.fortil.classical;

public class SyncService {
    private static final long THREAD_1_DURATION_SEC = 60;
    private static final long THREAD_2_DURATION_SEC = 5;

    public static void main(String[] args) {
        new SyncService().executeServices();

    }

    public void executeServices() {
        Thread service1Thread = new Thread(() -> {
            System.out.println("Service 1 started");
            try {
                for (int i = 0; i < THREAD_1_DURATION_SEC; i++) {
                    System.out.println("Service 1 in progress: " + (i + 1) + "/" + THREAD_1_DURATION_SEC + " seconds");
                    Thread.sleep(1000); // Sleep for 1 second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Service 1 finished");
        });

        Thread service2Thread = new Thread(() -> {
            System.out.println("Service 2 started");
            try {
                for (int i = 0; i < THREAD_2_DURATION_SEC; i++) {
                    System.out.println("Service 2 in progress: " + (i + 1) + "/" + THREAD_2_DURATION_SEC + " seconds");
                    Thread.sleep(1000); // Sleep for 1 second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Service 2 finished");
        });

        Thread service3Thread = new Thread(() -> {
            try {
                Thread service3_1Thread = new Thread(() -> {
                    System.out.println("Service 3.1 started");
                    try {
                        for (int i = 0; i < THREAD_1_DURATION_SEC; i++) {
                            System.out.println("Service 3.1 in progress: " + (i + 1) + "/" + THREAD_1_DURATION_SEC + " seconds");
                            Thread.sleep(1000); // Sleep for 1 second
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Service 3.1 finished");
                });
                service3_1Thread.start(); // Start Service 1
                service3_1Thread.join(); // Wait for Service 1 to finish

                // Launch 5 iterations of Service 2
                for (int i = 0; i < 5; i++) {
                    int finalI = i;
                    Thread service3_2Thread = new Thread(() -> {
                        System.out.println("### Starting Service 3.2 iteration " + (finalI + 1) + " : ###");
                        System.out.println("Service 3.2 started");
                        try {
                            for (int j = 0; j < THREAD_2_DURATION_SEC; j++) {
                                System.out.println("Service 3.2 in progress: " + (j + 1) + "/" + THREAD_2_DURATION_SEC + " seconds");
                                Thread.sleep(1000); // Sleep for 1 second
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Service 3.2 finished");
                    });
                    service3_2Thread.start(); // Start Service 2
                    service3_2Thread.join(); // Wait for Service 2 to finish
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Service 3 finished");
        });


        // Launch successively all threads
        try {
            System.out.println("### Starting Service 1 : ###");
            service1Thread.start();
            service1Thread.join(); // Wait for Service 1 to finish
            System.out.println("### Starting Service 2 : ###");
            service2Thread.start(); // Start Service 2
            service2Thread.join(); // Wait for Service 2 to finish
            System.out.println("### Starting Service 3 : ###");
            long startTime = System.currentTimeMillis();    // We want to know the execution duration of service 3
            service3Thread.start(); // Start Service 3
            service3Thread.join();
            long endTime = System.currentTimeMillis();
            System.out.println("Duration: " + (endTime - startTime) / 1000 + " seconds");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

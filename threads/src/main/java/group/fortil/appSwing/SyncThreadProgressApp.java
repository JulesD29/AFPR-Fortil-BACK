package group.fortil.appSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SyncThreadProgressApp extends JFrame {

    private static final long THREAD_1_DURATION_SEC = 60;
    private static final long THREAD_2_DURATION_SEC = 5;

    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel labelService2Iterations;
    private JLabel labelTimer;

    private long startTime;

    public SyncThreadProgressApp() {
        setTitle("Thread Progress Synchronous");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JLabel label1 = new JLabel("Service 1 in progress:");
        add(label1);
        progressBar1 = new JProgressBar(0, (int) THREAD_1_DURATION_SEC);
        progressBar1.setString("0 sec");
        progressBar1.setStringPainted(true);
        add(progressBar1);

        JLabel label2 = new JLabel("Service 2 in progress:");
        add(label2);
        progressBar2 = new JProgressBar(0, 5); // 5 tours
        progressBar2.setString("0 sec");
        progressBar2.setStringPainted(true);
        add(progressBar2);

        JLabel labelIterations = new JLabel("Service 2 iterations:");
        add(labelIterations);
        labelService2Iterations = new JLabel("0");
        add(labelService2Iterations);

        JLabel labelTimerTitle = new JLabel("Duration:");
        add(labelTimerTitle);
        labelTimer = new JLabel("0 second");
        add(labelTimer);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTime = System.currentTimeMillis();
                startTasks();
            }
        });
        add(startButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SyncThreadProgressApp app = new SyncThreadProgressApp();
                app.setVisible(true);
            }
        });
    }

    private void startTasks() {
        final CountDownLatch latch = new CountDownLatch(1);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= THREAD_1_DURATION_SEC; i++) {
                    final int progress = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar1.setValue(progress);
                            progressBar1.setString(progress + " sec"); // Update string with time in seconds
                            labelTimer.setText(String.format("%d seconds", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                latch.countDown(); // Signal that thread 1 has finished
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await(); // Wait for thread 1 to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 5; i++) {
                    for (int j = 1; j <= THREAD_2_DURATION_SEC; j++) {
                        final int progress = j;
                        int finalI = i;
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                progressBar2.setValue(progress);
                                progressBar2.setString(progress + " sec"); // Update string with time in seconds
                                labelService2Iterations.setText(Integer.toString(finalI + 1));
                                labelTimer.setText(String.format("%d seconds", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread2.start();
    }
}

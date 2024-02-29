package group.fortil.appSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class AsyncThreadProgressApp extends JFrame {

    private static final long THREAD_1_DURATION_SEC = 60;
    private static final long THREAD_2_DURATION_SEC = 5;
    private static final long LAPS_NUMBER_SERVICE_2 = 5;

    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel labelService2Iterations;
    private JLabel labelTimer;

    private long startTime;

    public AsyncThreadProgressApp() {
        setTitle("Thread Progress");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JLabel label1 = new JLabel("Service 1 in progress:");
        //label1.setHorizontalAlignment(1);
        add(label1);
        progressBar1 = new JProgressBar(0, (int) THREAD_1_DURATION_SEC);
        progressBar1.setStringPainted(true);
        add(progressBar1);

        JLabel label2 = new JLabel("Service 2 in progress:");
        add(label2);
        progressBar2 = new JProgressBar(0, (int) THREAD_2_DURATION_SEC);
        progressBar2.setStringPainted(true);
        add(progressBar2);

        JLabel labelIterations = new JLabel("Service 2 iterations:");
        add(labelIterations);
        labelService2Iterations = new JLabel("0/" + LAPS_NUMBER_SERVICE_2);
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
                AsyncThreadProgressApp app = new AsyncThreadProgressApp();
                app.setVisible(true);
            }
        });
    }

    private void startTasks() {
        SwingWorker<Void, Integer> worker1 = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 1; i <= THREAD_1_DURATION_SEC; i++) { // Service 1 lasts for 60 seconds
                    Thread.sleep(1000); // Sleep for 1 second
                    publish(i); // Update progress
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int latestProgress = chunks.get(chunks.size() - 1);
                progressBar1.setValue(latestProgress);
                progressBar1.setString(latestProgress + " sec"); // Update string with time in seconds
                labelTimer.setText(String.format("%d seconds", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
            }
        };
        worker1.execute();

        SwingWorker<Void, Integer> worker2 = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < LAPS_NUMBER_SERVICE_2; i++) { // Run Service 2 five times
                    for (int j = 1; j <= THREAD_2_DURATION_SEC; j++) { // Service 2 lasts for 5 seconds each
                        Thread.sleep(1000); // Sleep for 50 milliseconds
                        publish(j); // Update progress
                        labelService2Iterations.setText(String.valueOf(i + 1) + "/" + LAPS_NUMBER_SERVICE_2); // Update label with number of iterations
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int latestProgress = chunks.get(chunks.size() - 1);
                progressBar2.setValue(latestProgress);
                progressBar2.setString(latestProgress + " sec"); // Update string with time in seconds
                labelTimer.setText(String.format("%d seconds", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));

            }
        };
        worker2.execute();
    }
}
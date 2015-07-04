package com.cloudwick.project1;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ahuja on 3/22/15.
 */
public class ThreadFile {


    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();

        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private static class MessageLoop
            implements Runnable {

        public void run() {

           Lock lock = new ReentrantLock();
          lock.lock();


            try {

                for (int i = 0;
                     i < 50;
                     i++) {

                    PrintWriter outFile = new PrintWriter(new FileWriter("/Users/ahuja/Desktop/thread.txt", true));
                    // PrintWriter writer = new PrintWriter("/Users/ahuja/Desktop/thread.txt");
                    outFile.println("Okay " + Thread.currentThread().getName());
                    outFile.close();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lock.unlock();


        }
    }


    public static void main(String args[])
            throws InterruptedException {


        long patience = 1000 * 60 * 60;


        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 4; i++) {

            Thread t = new Thread(new MessageLoop());
            t.setName("Thread " + i);
            t.start();


//        Thread t1 = new Thread(new MessageLoop());
//        t1.setName("Bar");
//        //  t1.setPriority(1);
//        //t1.setDaemon(true);
//        t1.start();

            threadMessage("Waiting for MessageLoop thread to finish");
            // loop until MessageLoop
            // thread exits

            while (t.isAlive()) {

                //  t.join(1000);
                // t1.join(1000);


                if (((System.currentTimeMillis() - startTime) > patience)
                        && t.isAlive()) {
                    threadMessage("Tired of waiting!");


                    t.join();
                }
            }
        }
        threadMessage("Finally!");
    }


}
//}

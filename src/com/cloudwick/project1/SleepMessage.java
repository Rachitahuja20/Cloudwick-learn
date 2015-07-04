package com.cloudwick.project1;

/**
 * Created by ahuja on 3/22/15.
 */
public class SleepMessage {


        public static void main(String args[])
                throws InterruptedException {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (int i = 0;
                 i < importantInfo.length;
                 i++) {
                //Pause for 4 second
                   Thread.sleep(4000);

                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }

                System.out.println(importantInfo[i]);
            }
        }
    }


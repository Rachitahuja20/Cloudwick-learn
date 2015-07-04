package com.cloudwick.project1;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by ahuja on 3/15/15.
 */
public class numberlocator implements inumberlocator {


    public int AddSeqExcept(int max, List<Integer> except) {
        int i = 0;
        int s = 0;

        int c = 0;


//        System.out.println("Please provide the number");
//        int a = in.nextInt();
//
//        //System.out.println("except the number");
//        int b = in.nextInt();
//System.out.println("except the number");

        if(max<=0)
        {
            throw new IllegalArgumentException ("less than 0");
        }

         else {
            for (i = 1; i <= max; i++) {

                for (int j = 0; j < except.size(); j++) {
                    int currentElement = except.get(j);

                    if (i % currentElement == 0) {
                        s = s;
                    } else s = i + s;

                }


            }
        }
            return s;
    }
    }

package com.cloudwick.project1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by ahuja on 6/9/15.
 */
public class RandNumGen {

    public void Randomnum() {


        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the upper limit");
        int upper = in.nextInt();


        Random rn = new Random();
        for(int i=0; i<10; i++) {
        int answer = rn.nextInt(upper) + 1;

            

            System.out.println(answer);
        }

    }



    public static void main(String[] args) {

        RandNumGen file = new RandNumGen();
        file.Randomnum();
    }

}

package com.cloudwick.project1;

/**
 * Created by ahuja on 4/1/15.
 */
public class Word {

    int count=0;

    public void increment()
    {
        count++;
    }

    public static void main(String args[])
    {
        Word obj1=new Word();
        Word obj2=new Word();
        obj1.increment();
        obj1.increment();
        System.out.println("Obj1: count is="+obj1.count);
        System.out.println("Obj2: count is="+obj2.count);
    }




}

package com.cloudwick.project1;

import junit.framework.Assert;
import org.junit.Test;


/**
 * Created by ahuja on 3/28/15.
 */
public class FileReadTest {


    public void ReadFile_Test() {

        //Arrange

        FileRead uut = new FileRead();
        int expected = 287;


        String path= "/Users/ahuja/Desktop/Rachit.txt";

        //Act
        int actual = uut.ReadFile(path);

        //Assert

        Assert.assertEquals(expected, actual);

    }
}

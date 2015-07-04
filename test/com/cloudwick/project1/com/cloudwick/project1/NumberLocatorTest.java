package com.cloudwick.project1;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by ahuja on 3/15/15.
 */
public class NumberLocatorTest {

    void AddSeqExcept_One_One_Zero() {

    }

    @Test
   public void AddSeqExcept_Ten_FiveSeven_ThirtyThree() {

        //Arrange

        inumberlocator uut = new numberlocator();
        int expected = 33;


        List except = new ArrayList<Integer>();
        except.add(5);
        except.add(7);

        //Act
        int actual = uut.AddSeqExcept(10, except);

        //Assert

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void AddSeqExcept_LessThanZero() {

        //Arrange

        inumberlocator uut = new numberlocator();
        int expected = 33;


        List except = new ArrayList<Integer>();
        except.add(5);
        except.add(7);

        //Act
        int actual = uut.AddSeqExcept(-3, except);

        //Assert

        Assert.fail("Should not come here, but fails on prev line with exception");

    }


    @Test
    public void ReadFile_Six_Words() {

        //Arrange

        FileRead uut = new FileRead();
        int expected = 53;


        String path= "/Users/ahuja/Desktop/Rachit.txt";

        //Act
        int actual = uut.ReadFile(path);

        //Assert

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void ReadFile_HASHMAP() {

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
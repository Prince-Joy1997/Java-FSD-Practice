package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ArithmeticTest {



    Arithmetic arithmetic;
    @BeforeMethod
    public void setUp() {
        arithmetic = new Arithmetic();
    }
    @AfterMethod
    public void tearDown() {
       arithmetic = null;
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(30,arithmetic.add(10,20));
    }

    @Test
    public void testDifference() {
        Assert.assertEquals(10,arithmetic.difference(20,10));
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivision() {
        Assert.assertEquals(4,arithmetic.division(20,5));
        arithmetic.division(20,0);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(200,arithmetic.multiply(20,10));
    }

    @Test
    public void testEvenList(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Assert.assertEquals("[2, 4, 6, 8, 10]",arithmetic.EvenList(list).toString());
    }

}
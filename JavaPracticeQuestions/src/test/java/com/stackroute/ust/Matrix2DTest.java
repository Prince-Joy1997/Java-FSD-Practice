package com.stackroute.ust;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix2DTest {

    private Matrix2D matrix;
    @BeforeEach
    void setUp() {
        matrix = new Matrix2D();
    }

    @AfterEach
    void tearDown() {
        matrix = null;
    }

    @Test
    void searchMatrix() {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Assertions.assertEquals(true,matrix.SearchMatrix(arr,3));
        Assertions.assertEquals(false,matrix.SearchMatrix(arr,13));
    }
}
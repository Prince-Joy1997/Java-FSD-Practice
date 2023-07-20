## Problem Statement: Find the average of an array using for and for-each loop

**Given a positive integers array find the average of the numbers in that array using for-each loop**

**This exercise contains a class named NumberAverage with the following methods:**

     +findAverage(int[]) : String  
         - Should take positive integer array as input and return a String with the average calculated
         - The average of the array should be calculated by using a for-each loop 
         - Should send error message if all value in array are not positive
         - Should send error message if array is empty
------------------------------------------------------
     +getArrayValues() : void
         - Should get the values of the array from the user using for loop
         - Should get input values of int datatype  
         - Should pass the array to method findAverage and print the result from the method


## Example
    Sample Input:
    Enter number of values:
    6
    Enter the values:
    12 13 14 15 16 17
    
    Expected Output:
    The average value is: 14
--------------------------------------------------------
    Sample Input:
    Enter number of values:
    5
    Enter the values:
    12 13 -14 15 16 17 
       
    Expected Output:
    Give proper positive integer values

## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
package com.stackroute.commonjavaclasses;

public class ISBNValidator {

    public int validateISBNNumber(String validValues) throws NumberFormatException {


        try{
            if(validValues == null || validValues == ""){
                return -1;
            }
            long validNumber = Long.parseLong(validValues);
            if(validValues.length()!=10){
                return 0;
            }
            else{
                long result =0,n=0,i=1;
                while(validNumber!=0){
                    n=validNumber%10;
                    result=result+(n*i);
                    i++;
                    validNumber=validNumber/10;
                }
                if(result%11 == 0){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }catch(NumberFormatException e){
            throw e;
        }

    }

}

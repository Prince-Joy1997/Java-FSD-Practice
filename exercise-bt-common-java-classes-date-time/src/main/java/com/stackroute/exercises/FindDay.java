package com.stackroute.exercises;


import java.time.LocalDate;

public class FindDay {

    //write logic to find day of the date and return result
    public String findDay(int month, int day, int year) {

        String result = "";
        int flag = 0;

    if(month<1 || month>12){

        result = result + "Give month in range";
        flag = 1;

    }

    if(day<1 || day>31){

        result = result + "Give day in range";
        flag = 1;

    }


    if(year<2000 || year>3000){

        result = result + "Give year in range";
        flag = 1;

    }

    if (flag == 0){

        LocalDate date = LocalDate.of(year,month,day);
        result = date.getDayOfWeek().toString();

    }
        return result;
    }
}

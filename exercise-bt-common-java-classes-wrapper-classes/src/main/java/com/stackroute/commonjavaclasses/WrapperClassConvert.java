package com.stackroute.commonjavaclasses;

public class WrapperClassConvert {

    //write logic to determine and convert given primitive type to its wrapper class and return result
    public Object convertToWrapper(Object input) {
        
        if(input instanceof Integer){
            Integer result = (Integer) input;
            return result;
        }
        else if (input instanceof Byte) {
            Byte result = (Byte) input;
            return result;
        }
        else if (input instanceof  Short) {
            Short result = (Short) input;
            return result;
        }
        else if (input instanceof Long) {
            Long result = (Long) input;
            return result;
        }
        else if (input instanceof Float) {
            Float result = (Float) input;
            return result;
        }
        else if (input instanceof Double) {
            Double result = (Double) input;
            return result;
        }
        else if (input instanceof Boolean) {
            Boolean result = (Boolean) input;
            return result;
        }
        else if (input instanceof Character) {
            Character result = (Character) input;
            return result;
        }
        return "Give proper primitive type as input";
    }
}


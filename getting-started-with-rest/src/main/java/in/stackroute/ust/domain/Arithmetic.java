package in.stackroute.ust.domain;

import org.springframework.stereotype.Component;

public record Arithmetic(int num1, int num2, int result, String operation) {

}

//public class Arithmetic {
//    private int num1;
//    private int num2;
//    private int result;
//    private String operation;
//
//    public Arithmetic(){
//
//    }
//
//    public Arithmetic(int num1, int num2, int result, String operation) {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.result = result;
//        this.operation = operation;
//    }
//
//    public int getNum1() {
//        return num1;
//    }
//
//    public void setNum1(int num1) {
//        this.num1 = num1;
//    }
//
//    public int getNum2() {
//        return num2;
//    }
//
//    public void setNum2(int num2) {
//        this.num2 = num2;
//    }
//
//    public int getResult() {
//        return result;
//    }
//
//    public void setResult(int result) {
//        this.result = result;
//    }
//
//    public String getOperation() {
//        return operation;
//    }
//
//    public void setOperation(String operation) {
//        this.operation = operation;
//    }
//}


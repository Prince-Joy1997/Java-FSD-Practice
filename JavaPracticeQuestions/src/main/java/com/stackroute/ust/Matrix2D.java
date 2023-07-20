package com.stackroute.ust;

public class Matrix2D {

//    public static void main(String[] args) {
//        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        System.out.println(SearchMatrix(arr,3));
//        System.out.println(SearchMatrix(arr,13));
//    }

    public  boolean SearchMatrix(int[][] arr, int target){

        for(int i = 0; i < 3;i++){
            if(target >= arr[i][0] && target <= arr[i][3]){
                for(int j = 0; j < 4;j++){
                    if(target == arr[i][j]){
                        return true;
                    }
                }
            }
            return false;
        }

        return false;
    }
}

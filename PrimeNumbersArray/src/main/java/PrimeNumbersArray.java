import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            for (int j=2; j<i; j++){
                if(i%j==0){
                    System.out.println(list.add(arr[i]));
                    break;
                }
            }
        }
    }

}

public class Partition {

    public static void main(String[] args) {

        System.out.println(canPartition(new int []{2, 8, 4, 1}));
        System.out.println(canPartition(new int []{-1, -10, 1, -2, 20}));
        System.out.println(canPartition(new int []{-1, -20, 5, -1, -2, 2}));
    }

    private static boolean canPartition(int[] arr) {
        int prdt=1;
        for(int i=0;i< arr.length;i++) {

            prdt *= arr[i];

        }
            for(int j=1;j< arr.length;j++){

                if(prdt/arr[j] == arr[j]){
                    return true;
                }

            }
        return false;
    }


}

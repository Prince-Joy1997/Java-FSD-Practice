public class EverIncreasingDereasingArray {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4, 4};
        System.out.println(EverIncreasingDereasingArray(arr));
    }

        private static int EverIncreasingDereasingArray(int[] arr) {
            int c1 = 1, c2 = 1, count1 = c1, count2 = c2;

            for (int i = 0; i < arr.length-1; i++) {

                if (arr[i] < arr[i + 1]) {
                    c1++;
                } else {
                    if (c1 > count1) {
                        count1 = c1;
                    }
                }
            }
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    c1++;
                } else {
                    if (c2 > count2) {
                        count2 = c2;
                    }
                }
            }

            if (count1 > count2) {
                return count1;
            }
            return count2;
        }
}

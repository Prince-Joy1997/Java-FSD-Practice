public class PiggyBank {
    public static void main(String[] args) {

        System.out.println(NumberOfDays(2050,1200,10));

    }

    public static int NumberOfDays(int cost, int savings, int start) {
        int flag = 0, temp = 0;

        while(savings <= cost){
            temp = start;

            for(int i = 0; i <= 7; i++){
                savings += temp;
                temp++;
                flag++;
                if(savings >= cost)
                    break;
            }
            start++;
        }
        return flag;
    }
}

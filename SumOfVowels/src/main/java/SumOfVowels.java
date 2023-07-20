public class SumOfVowels {
    public static void main(String[] args) {
        System.out.println(sumOfVowels("My world evolves around Tesha's."));
    }

    private static int sumOfVowels(String s) {
        int r = 0;
        char ch ;
        for(int i=0; i<s.length();i++){
            ch = s.charAt(i);

            if(ch == 'A' || ch == 'a'){
                r=r+4;
            }

            if(ch == 'E' || ch == 'e'){
                r=r+3;
            }
            if(ch == 'I' || ch == 'i'){
                r=r+1;
            }
            if(ch == 'O' || ch == 'o'){
                r=r+0;
            }
        }
        return r;
    }
}

public class LeapYearOrNot {

    public static void main(String[] args) {
//        System.out.println(isLeapYear(2022));
    }
    public String isLeapYear(int year) {
//            year % 4 == 0
//            year % 100 != 0
//            year % 400 == 0

        if(year % 4 == 0){
            if(year % 100 != 0){
                return "Leap year";
            }
        }
        else if(year % 400 == 0){
            return "Leap year";
        }
        else {
            return "Not a leap year";
        }
        return "Not a leap year";
    }
}

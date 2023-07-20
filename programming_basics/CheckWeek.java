import java.util.Scanner;

public class CheckWeek {
    public static void main(String[] args) {
        String input;
        CheckWeek obj = new CheckWeek();
        System.out.println("Enter the day : ");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        String result = obj.checkWeekDay(input);
        System.out.println(result);
    }

    String checkWeekDay(String week){
        if(week.equalsIgnoreCase("Sunday")) {
            return "This is the First Day of the week";
            }
            else if(week.equalsIgnoreCase("Monday")) {
                return "This is the Second Day of the week";
            }
            else if(week.equalsIgnoreCase("Tuesday")){
                return "This is the Third Day of the week";
            }
            else if(week.equalsIgnoreCase("Wednesday")){
                return "This is the Fourth Day of the week";
            }
            else if(week.equalsIgnoreCase("Thursday")) {
                return "This is the Fifth Day of the week";
            }
            else if(week.equalsIgnoreCase("Friday")) {
                return "This is the Sixth Day of the week";
            }

	    else{
                return "This is the Last Day of the week";
            }

    }

}

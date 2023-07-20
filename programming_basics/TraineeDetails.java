public class TraineeDetails {
    public static void main(String[] args) {

        Trainee t1 = new Trainee();
        t1.employee_name = "Prince Joy";
        t1.employeeID = 233693;
        t1.age = 25;
        t1.salary = 20000.0f;
        t1.printDetails();
    }
}

class Trainee{

    int employeeID;
    String employee_name;
    int age;
    float salary;

    void printDetails(){

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Trainee Details are: ");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Name : "+employee_name+"\nEmployee ID : "+employeeID+"\nAge : "+age+"\nSalary : "+salary);

    }
}

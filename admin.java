public class Admin {

    int staffID;
    String position;
    String start_date;
    int Salary;

public Admin(int staffID, String position, String start_date, int Salary){
    this.staffID = staffID;
    this.position = position;
    this.start_date = start_date;
    this.Salary = Salary;
}

public static void main(String[] args) {
    test();
}


void EditAccount(String type, int number){
    //send request to nosql
}

void EditAccount(String type, String info){
    //send request to nosql
}

void EditBalance(String type, int cardnumber, int amount){
    //send request to nosql
}

static void test(){
    System.out.println("good");
}

}
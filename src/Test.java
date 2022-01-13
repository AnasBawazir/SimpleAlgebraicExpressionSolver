
public class Test {


    public static void main(String[] args) {
        Marks m = new Marks(1,2,500);
        m.print();


    }
}

class Degree {
    int num1,num2;


    Degree(int job,int emp) {
        this.num1=job;
        this.num2=emp;
    }
}
class Marks extends Degree{

int num3;
    Marks(int job, int emp,int salary) {
        super(job, emp);
        this.num3=salary;
    }
    void print(){
        System.out.println(num1+" " + num2 +" "+ num3);
    }
}




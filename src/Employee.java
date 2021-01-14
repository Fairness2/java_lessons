import java.text.DecimalFormat;

public class Employee {
    protected String fio;
    protected String position;
    protected String email;
    protected String phone;
    protected double salary;
    protected int age;

    public Employee(){ }

    public Employee(String fio, String position, String email, String phone, double salary, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String show(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("ФИО: %s, Должность: %s, Email: %s, Телефон: %s, Зарпалта: %s, Возраст: %s", this.fio, this.position, this.email, this.phone, decimalFormat.format(this.salary), this.age);
    }

    public void print(){
        System.out.println(this.show());
    }

    public int getAge() {
        return this.age;
    }
}

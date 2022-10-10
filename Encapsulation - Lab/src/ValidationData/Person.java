package ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void increaseSalary(double bonus) {
        if (age < 30) {
            this.setSalary(this.getSalary() + this.getSalary() * bonus / 200);
        } else {
            this.setSalary(this.getSalary() + this.getSalary() * bonus / 100);
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }else{
        this.salary = salary;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() >= 3){
        this.firstName = firstName;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
        this.age = age;
        }else{
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", firstName, lastName, age);
    }
}


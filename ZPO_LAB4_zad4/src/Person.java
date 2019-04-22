import java.util.ArrayList;

public class Person {

    private String name;
    private String secondName;
    private String country;
    private int salary;

    public Person(String name, String secondName, String country, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.country = country;
        this.salary = salary;
    }

    public Person(String personalData){
        String[] personalDataTab =personalData.split(" ");
        this.name = personalDataTab[0];
        this.secondName = personalDataTab[1];
        this.country = personalDataTab[2];
        this.salary = Integer.parseInt(personalDataTab[3]);
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getCountry() {
        return country;
    }

    public int getSalary() {
        return salary;
    }
}

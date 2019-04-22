import java.util.ArrayList;
import java.util.List;

public class StudentListGuavaMain {
    public StudentListGuavaMain() {
        List<Student> kolekcjaStudentów = new ArrayList<>();
        kolekcjaStudentów.add(new Student(
                "Jan",
                "Kowalski",
                "1996-10-03",
                180));
        kolekcjaStudentów.add(new Student(
                "Zofia",
                "Skalska",
                "1994-04-04",
                160));
        kolekcjaStudentów.add(new Student(
                "Tomasz",
                "Stefański",
                "1996-12-23",
                190));
        kolekcjaStudentów.add(new Student(
                "Katarzyna",
                "Dąbrowska",
                "1996-04-05",
                170));
        kolekcjaStudentów.add(new Student(
                "Jakub",
                "Lajkonik",
                "1993-05-05",
                170));
        kolekcjaStudentów.add(new Student(
                "Anna",
                "Kowalska",
                "1996-01-20",
                195));

        System.out.println("-----------Guava----------");
        printStudents(kolekcjaStudentów);
        kolekcjaStudentów.sort(Student::GuavaCompareTo);
        System.out.println();
        printStudents(kolekcjaStudentów);
        System.out.println("--------------------------");
        System.out.println();

    }

    public void printStudents(List<Student> kolekcjaStudentów){
        for (int i = 0; i < kolekcjaStudentów.size(); i++) {
            System.out.println(kolekcjaStudentów.get(i));
        }
    }

}

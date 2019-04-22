import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.common.collect.ComparisonChain;

public class Student {
    private String imie;
    private String nazwisko;
    private Date dataUrodzenia;
    private int wzrostWcm;

    public Student(String imie, String nazwisko, String dataUrodzenia, int wzrostWcm) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        try {
            this.dataUrodzenia = new SimpleDateFormat("yyyy-mm-dd").parse(dataUrodzenia);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("podano datę w złym formacie - Dopuszczony: \"yyyy-mm-dd\"");
        }
        this.wzrostWcm = wzrostWcm;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public int getWzrostWcm() {
        return wzrostWcm;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", wzrostWcm=" + wzrostWcm +
                '}';
    }

    public int GuavaCompareTo(Student student) {
        return ComparisonChain.start()
                .compare(this.getDataUrodzenia().getYear(), student.getDataUrodzenia().getYear())
                .compare(this.getNazwisko().charAt(0), student.getNazwisko().charAt(0))
                .compare(student.getWzrostWcm(), this.getWzrostWcm())
                .result();
    }

    public int JDKCompareTo(Student student) {
        if (this.getDataUrodzenia().getYear() > student.getDataUrodzenia().getYear()) return 1;
        else if (this.getDataUrodzenia().getYear() < student.getDataUrodzenia().getYear()) return -1;
        else{
            if (this.getNazwisko().charAt(0) > student.getNazwisko().charAt(0)) return 1;
            if (this.getNazwisko().charAt(0) < student.getNazwisko().charAt(0)) return -1;
            else {
                if (this.getWzrostWcm() > student.getWzrostWcm()) return -1;
                if (this.getWzrostWcm() < student.getWzrostWcm()) return 1;
                else return 0;
            }
        }
    }
}

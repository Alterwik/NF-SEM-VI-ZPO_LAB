import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
    //a
        LocalDate WWII_begin = LocalDate.of(1939, 9, 1);
        LocalDate WWII_end = LocalDate.of(1945, 5, 8);

        System.out.println("Data rozpoczęcia II wojny swiatowej" + WWII_begin);
        System.out.println("Data zakonczenia II wojny swiatowej" + WWII_end);

        System.out.println("II wojna swiatowa trwala: " + ChronoUnit.DAYS.between(WWII_begin, WWII_end) +"dni");

    //b
        LocalDate y2016 = LocalDate.of(2016, 1, 1);
        System.out.println("68-my dzien 2016 roku wypada " + y2016.plusDays(68 - 1));

    //c
        LocalDate birthday = LocalDate.of(1995, Month.APRIL, 1);
        LocalDate localDate = birthday;
        int counter = 0;
        while(localDate.isBefore(LocalDate.now())){
            localDate = localDate.plusDays(1);
            //System.out.println(localDate);
            if(localDate.toString().contains("-02-29")){
                counter++;
                //System.out.println("---------------------------");
            }
        }
        System.out.println("Przeżyłem " + counter + " dni 29 lutego.");
    }
}

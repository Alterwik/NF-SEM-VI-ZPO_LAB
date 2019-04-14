import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final int NUMBER_OF_CYCLISTS_TO_CHOOSE = 15;
    private static final String URL = "http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt";

    public static void main(String[] args) throws IOException {

        Handler fileHandler;


        fileHandler = new FileHandler("./race.log", false);
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.addHandler(fileHandler);
        logger.setLevel(Level.FINE);


        CyclistList listakolarzy = new CyclistList(URL, NUMBER_OF_CYCLISTS_TO_CHOOSE);
        System.out.println("Lista Kolarzy ("+ listakolarzy.size()+"): "+listakolarzy);

        Race wyscig = new Race(listakolarzy);
        wyscig.start();
    }
}

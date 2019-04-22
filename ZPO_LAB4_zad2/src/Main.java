import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String s = "Ala ma kota";
        MySplitter mySplitter = new MySplitter();
        ArrayList<String> list = mySplitter.split(s, 3);
        mySplitter.printList(list);
    }

}

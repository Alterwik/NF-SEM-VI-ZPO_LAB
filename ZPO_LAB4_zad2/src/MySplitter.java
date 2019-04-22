import java.util.ArrayList;

public class MySplitter {

    public static ArrayList<String> split(String s, int length){
        if(length <= 0)throw new IllegalArgumentException("length must be greater than zero");
        if(s == null)throw new IllegalArgumentException("the given string can not be equal to null");
        ArrayList<String> list = new ArrayList<>();
        while (length<s.length()){
            list.add(s.substring(0,length));
            s=s.substring(length);
        }
        list.add(s);
        return list;
    }

    public void printList(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

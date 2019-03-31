public class Main {

    public static void main(String[] args) {
        String string = buildStringOfParameters(args);
        //String string = "minus jeden dwa trzy";
        //String string = "dzie dwa trzy";
        //String string = "cztery pięć sześć";
        //String string = "minus dziewięć osiem siedem";
        //String string = "trolo dzie dwa trzy";
        int out = StringToIntConverter.convert(string);
        if(out < 1000){
            System.out.println(out);
        }
    }

    private static String buildStringOfParameters(String[] args){
        String string;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            if (i < args.length -1 ){
                sb.append(" ");
            }
        }
        string = sb.toString();
        //System.out.println(string);
        return string;
    }
}

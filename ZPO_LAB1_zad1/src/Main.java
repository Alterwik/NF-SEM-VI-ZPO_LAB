public class Main {

    public static void main(String[] args) {
        String input = args[0];
        System.out.println("Podano parametr: "+args[0]);
        int liczba = 0b1101_1000;
        int radix = 10;
        //input="trzy";
        //input="szesnaście";
        switch(input){
            case "dziesięć":
                radix = 10;
                break;
            case "trzy":
                radix = 3;
                break;
            case "szesnaście":
                radix = 16;
                break;
                default:
                    System.out.println("błąd! podano zły parametr. Dopuszczalne: 'dziesięć', 'trzy', 'szesnaście'.");
        }
        System.out.println("liczba: "+Integer.toString(liczba, radix));
    }
}

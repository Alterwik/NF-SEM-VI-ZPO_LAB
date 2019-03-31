public class Main {

    public static void main(String[] args) {
        String strPesel = "95090406598";
        System.out.println("Given PESEL   : "+strPesel);
        Pesel pesel = new Pesel(strPesel);
        pesel.printBirthDateAndGender();
    }
}

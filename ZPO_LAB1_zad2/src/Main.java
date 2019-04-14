public class Main {

    public static void main(String[] args) {
        String strPesel = "fsd";
        System.out.println("Given PESEL   : "+strPesel);
        Pesel pesel = new Pesel(strPesel);
        pesel.printBirthDateAndGender();
    }
}

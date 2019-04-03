public class Main {

    public static void main(String[] args) {
        try {
            Publication k1 = new Book(
                    "Adam Mickiewicz",
                    "Pan Tadeusz",
                    340);

            Publication k2 = new Book(
                    "Adam Mickiewicz",
                    "Dziady",
                    130);

            System.out.println(k1);
            System.out.println(k2);
            Publication kk1 = new BookWithHardCover(k1);
            Publication kk2 = new BookWithSimpleCover(k2);
            System.out.println(kk1);
            System.out.println(kk2);
            System.out.println(kk2.getAuthor());

//            error
//            Publication kkk2err = new BookWithSimpleCover(kk2);
//            System.out.println(kkk2err);

            Publication kkk3 = new BookDustCover(kk1);
            System.out.println(kkk3);

//            errpr
//            Publication kkkk3err = new BookWithHardCover(kkk3);
//            System.out.println(kkkk3err);

//            error
//            Publication kkkk4err = new BookDustCover(kkk3);
//            System.out.println(kkkk4err);

//            error
//            Publication kderr = new BookDustCover(k1);
//            System.out.println(kderr);

// Pozostała funkcjonalność w MainTest.java

        }catch(WrongUsageOfBookDecoratorException e){
            e.printStackTrace();
        }
    }
}

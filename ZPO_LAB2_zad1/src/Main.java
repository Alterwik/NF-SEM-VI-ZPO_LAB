import AbstractFactory.PublishingHouse;
import Book.Book;
import Book.Publication;
import Decorator.BookDustCover;
import Decorator.BookWithHardCover;
import Decorator.BookWithSimpleCover;
import Decorator.WrongUsageOfBookDecoratorException;

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
//            Book.Publication kkk2err = new Decorator.BookWithSimpleCover(kk2);
//            System.out.println(kkk2err);

            Publication kkk3 = new BookDustCover(kk1);
            System.out.println(kkk3);

//            errpr
//            Book.Publication kkkk3err = new Decorator.BookWithHardCover(kkk3);
//            System.out.println(kkkk3err);

//            error
//            Book.Publication kkkk4err = new Decorator.BookDustCover(kkk3);
//            System.out.println(kkkk4err);

//            error
//            Book.Publication kderr = new Decorator.BookDustCover(k1);
//            System.out.println(kderr);

// Pozostała funkcjonalność w Decorator.BookDecoratorTest.java

        }catch(WrongUsageOfBookDecoratorException e){
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------------------");


        //Użycie:
        PublishingHouse w = PublishingHouse.getInstance("Józef Ignacy Kraszewski");
/* W zależności od autora wybieramy odpowiednie wydawnictwo. Wpisać kilka wariantów.
Tu powstanie wydawnictwo powieści historycznych */
        Book k = w.createBook("Masław", 280);
        /* Tworzy książkę klasy PowiescHistoryczna z podanym tytułem i liczbą stron. Autor przekazany będzie z wydawnictwa */
    }
}

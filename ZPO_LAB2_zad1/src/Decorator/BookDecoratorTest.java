package Decorator;

import Book.Book;
import Book.Publication;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class BookDecoratorTest {

    Publication kTester= new Book(
            "Adam Mickiewicz",
            "Pan Tadeusz",
            340);

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGetters() {
        Assert.assertEquals(kTester.getAuthor(), "Adam Mickiewicz");
        Assert.assertEquals(kTester.getNumberOfPages(), 340);
        Assert.assertEquals(kTester.getTitle(), "Pan Tadeusz");
    }

    @org.junit.Test
    public void shouldReturnCorrectString() {
        Assert.assertEquals(kTester.toString(),"| Adam Mickiewicz | Pan Tadeusz | 340");
    }

    @org.junit.Test
    public void shouldReturnCorrectValueWithCoverDecorator() {
        Publication kkTester = null;
        try {
            kkTester = new BookWithSimpleCover(kTester);
        } catch (WrongUsageOfBookDecoratorException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(kkTester.toString(),"| Adam Mickiewicz | Pan Tadeusz | 340 | Okładka zwykła |");
    }

    @Rule
    public ExpectedException thrown1 = ExpectedException.none();
    @org.junit.Test
    public void shouldReturnExceptionWhileUsingCoverDecoratorAgain() throws WrongUsageOfBookDecoratorException {
        Publication kkTester = new BookWithSimpleCover(kTester);
        thrown1.expect(WrongUsageOfBookDecoratorException.class);
        thrown1.expectMessage("wyjątek! Okładka może być tylko jedna");
        new BookWithHardCover(kkTester);
    }

    @org.junit.Test
    public void shouldReturnCorrectValueWithCoverWrapperDecorator() {
        Publication kkTester;
        Publication kkkTester = null;
        try {
            kkTester = new BookWithSimpleCover(kTester);
            kkkTester = new BookDustCover(kkTester);
        } catch (WrongUsageOfBookDecoratorException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(kkkTester.toString(),"| Adam Mickiewicz | Pan Tadeusz | 340 | Okładka zwykła | Z obwolutą |");
    }

    @Rule
    public ExpectedException thrown2 = ExpectedException.none();
    @org.junit.Test
    public void shouldReturnExceptionWhileUsingDustCoverDecoratorAgain() throws WrongUsageOfBookDecoratorException {
        Publication kkTester = new BookWithSimpleCover(kTester);
        Publication kkkTester = new BookDustCover(kkTester);
        thrown2.expect(WrongUsageOfBookDecoratorException.class);
        thrown2.expectMessage("wyjątek! Obwoluta może być tylko jedna");
        new BookDustCover(kkkTester);
    }

    @Rule
    public ExpectedException thrown3 = ExpectedException.none();
    @org.junit.Test
    public void shouldReturnExceptionWhileUsingCoverDecoratorAgainAfterDustCoverDecorator()
            throws WrongUsageOfBookDecoratorException {
        Publication kkTester = new BookWithHardCover(kTester);
        Publication kkkTester = new BookDustCover(kkTester);
        thrown3.expect(WrongUsageOfBookDecoratorException.class);
        thrown3.expectMessage("wyjątek! Okładka może być tylko jedna");
        new BookWithSimpleCover(kkkTester);
    }

    @Rule
    public ExpectedException thrown4 = ExpectedException.none();
    @org.junit.Test
    public void shouldReturnExceptionWhileUsingDustCoverOnPublicationWithoutCover()
            throws WrongUsageOfBookDecoratorException {
        thrown4.expect(WrongUsageOfBookDecoratorException.class);
        thrown4.expectMessage("wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki");
        new BookDustCover(kTester);
    }

    @Rule
    public ExpectedException thrown5 = ExpectedException.none();
    @org.junit.Test
    public void shouldReturnExceptionWhileTryingToGetAutographTwice()
            throws WrongUsageOfBookDecoratorException {
        Publication kaTester = new BookWithAutograph(kTester, "Drogiej Hani - Adam Mickiewicz");
        thrown5.expect(WrongUsageOfBookDecoratorException.class);
        thrown5.expectMessage("wyjątek! Autograf może być tylko jeden");
        new BookWithAutograph(kaTester, "Haniu, to nieprawda, Dziady napisałem ja, Julek Słowacki!");
    }

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGettersWhenDecorated() {
        try {
            Publication kkTester = new BookWithHardCover(kTester);
            Publication kkkTester = new BookDustCover(kkTester);
            Publication kkkkTester = new BookWithAutograph(kkkTester, "Drogiej Hani - Adam Mickiewicz");
            Assert.assertEquals(kkkkTester.getAuthor(), "Adam Mickiewicz");
            Assert.assertEquals(kkkkTester.getNumberOfPages(), 340);
            Assert.assertEquals(kkkkTester.getTitle(), "Pan Tadeusz");
            Assert.assertEquals(kkkkTester.toString(),
                    "| Adam Mickiewicz | Pan Tadeusz | 340 | Okładka twarda |" +
                            " Z obwolutą | Drogiej Hani - Adam Mickiewicz |");
        } catch (WrongUsageOfBookDecoratorException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ExpectedException thrown6 = ExpectedException.none();
    @org.junit.Test
    public void shouldReturnExceptionWhileTryingToGetAutographAgain()
            throws WrongUsageOfBookDecoratorException {
        Publication kaTester = new BookWithAutograph(kTester, "Drogiej Hani - Adam Mickiewicz");
        Publication kakTester = new BookWithSimpleCover(kaTester);
        Publication kakkTester = new BookDustCover(kakTester);
        thrown6.expect(WrongUsageOfBookDecoratorException.class);
        thrown6.expectMessage("wyjątek! Autograf może być tylko jeden");
        new BookWithAutograph(kakkTester, "Haniu, to nieprawda, Dziady napisałem ja, Julek Słowacki!");
    }

}
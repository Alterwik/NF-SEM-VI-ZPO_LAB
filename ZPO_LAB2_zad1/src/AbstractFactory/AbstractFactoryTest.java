package AbstractFactory;

import Book.Book;
import Book.Publication;
import org.junit.Assert;

public class AbstractFactoryTest {

    Publication kTester = new Book(
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
    public void shouldReturnCorrectValuesOfGettersInHistoricalBookCreatedByFactory() {
    PublishingHouse w = PublishingHouse.getInstance("Józef Ignacy Kraszewski");
    Book k = w.createBook("Masław", 280);
        Assert.assertEquals(k.getAuthor(), "Józef Ignacy Kraszewski");
        Assert.assertEquals(k.getNumberOfPages(), 280);
        Assert.assertEquals(k.getTitle(), "Masław");
    }

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGettersInThrillerBookCreatedByFactory() {
        PublishingHouse w = PublishingHouse.getInstance("Jan Thriller");
        Book k = w.createBook("Thriller", 285);
        Assert.assertEquals(k.getAuthor(), "Jan Thriller");
        Assert.assertEquals(k.getNumberOfPages(), 285);
        Assert.assertEquals(k.getTitle(), "Thriller");
    }

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGettersInPoemBookCreatedByFactory() {
        PublishingHouse w = PublishingHouse.getInstance("Mieczysław Poem");
        Book k = w.createBook("Poem", 180);
        Assert.assertEquals(k.getAuthor(), "Mieczysław Poem");
        Assert.assertEquals(k.getNumberOfPages(), 180);
        Assert.assertEquals(k.getTitle(), "Poem");
    }

}

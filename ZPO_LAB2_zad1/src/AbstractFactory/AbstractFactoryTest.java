package AbstractFactory;

import Book.Publication;
import org.junit.Assert;

public class AbstractFactoryTest {

    private static final String AUTHOR1 = "Józef Ignacy Kraszewski";
    private static final String AUTHOR2 = "Jan Thriller";
    private static final String AUTHOR3 = "Mieczysław Poem";
    private static final int  PAGES1 = 280;
    private static final int  PAGES2 = 285;
    private static final int  PAGES3 = 180;
    private static final String TITLE1 = "Masław";
    private static final String TITLE2 = "Thriller";
    private static final String TITLE3 = "Poem";


    private void checkIfCorrectValuesAreReturned(String author, String title, int pages) {
        PublishingHouse w = PublishingHouse.getInstance(author);
        Publication k = w.createBook(title, pages);
        Assert.assertEquals(k.getAuthor(), author);
        Assert.assertEquals(k.getNumberOfPages(), pages);
        Assert.assertEquals(k.getTitle(), title);
    }

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGettersInHistoricalBookCreatedByFactory() {
        checkIfCorrectValuesAreReturned(AUTHOR1, TITLE1, PAGES1);
    }

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGettersInThrillerBookCreatedByFactory() {
        checkIfCorrectValuesAreReturned(AUTHOR2, TITLE2, PAGES2);
    }

    @org.junit.Test
    public void shouldReturnCorrectValuesOfGettersInPoemBookCreatedByFactory() {
        checkIfCorrectValuesAreReturned(AUTHOR3, TITLE3, PAGES3);
    }



}

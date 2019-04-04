package AbstractFactory;

import Book.Book;

abstract public class PublishingHouse {

    public static PublishingHouse getInstance(String author) {
        if("Józef Ignacy Kraszewski".equalsIgnoreCase(author)) {
            return new HistoricalNovelPublishingHouse(author);
        }else if("Jan Thriller".equalsIgnoreCase(author)){
            return new ThrillerPublishingHouse(author);
        }else if("Mieczysław Poem".equalsIgnoreCase(author)){
            return new PoemPublishingHouse(author);
        }else{
            return null;
        }
    }

    abstract public Book createBook(String title, int numberOfPages);
}

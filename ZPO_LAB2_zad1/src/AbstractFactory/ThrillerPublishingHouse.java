package AbstractFactory;

import Book.Book;

public class ThrillerPublishingHouse extends PublishingHouse {

    String mAuthor;

    public ThrillerPublishingHouse(String author) {
        mAuthor = author;
    }

    @Override
    public Book createBook(String title, int numberOfPages) {
        return new HistoricalNovel(mAuthor, title, numberOfPages);
    }
}

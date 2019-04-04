package AbstractFactory;

import Book.Book;

public class PoemPublishingHouse extends PublishingHouse{

    String mAuthor;

    public PoemPublishingHouse(String author) {
        mAuthor = author;
    }

    @Override
    public Book createBook(String title, int numberOfPages) {
        return new HistoricalNovel(mAuthor, title, numberOfPages);
    }
}

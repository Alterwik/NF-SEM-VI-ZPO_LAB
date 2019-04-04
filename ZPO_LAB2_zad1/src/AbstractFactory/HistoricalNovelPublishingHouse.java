package AbstractFactory;

import Book.Book;

public class HistoricalNovelPublishingHouse extends PublishingHouse {

    String mAuthor;

    public HistoricalNovelPublishingHouse(String author) {
        mAuthor = author;
    }

    @Override
    public Book createBook(String title, int numberOfPages) {
        return new HistoricalNovel(mAuthor, title, numberOfPages);
    }
}

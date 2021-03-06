package Book;

public class Book implements Publication {

    private String mAuthor;
    private String mTitle;
    private int mNumberOfPages;

    public Book(String mAuthor, String mTitle, int mNumberOfPages) {
        this.mAuthor = mAuthor;
        this.mTitle = mTitle;
        this.mNumberOfPages = mNumberOfPages;
    }

    @Override
    public String getAuthor() {
        return mAuthor;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public int getNumberOfPages() {
        return mNumberOfPages;
    }

    @Override
    public String toString() {
        return "| " + mAuthor +
                " | " + mTitle +
                " | " + mNumberOfPages;
    }


}

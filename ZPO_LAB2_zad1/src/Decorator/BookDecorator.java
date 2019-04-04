package Decorator;

import Book.Publication;

abstract class BookDecorator implements Publication {

    protected boolean hasCover;
    protected boolean hasDustCover;
    protected boolean hasAutograph;

    private Publication decoratedPublication;

    public BookDecorator(Publication publication) {
        this.decoratedPublication = publication;
        this.hasCover = false;
        this.hasDustCover = false;
        this.hasAutograph = false;
    }

    @Override
    public String getAuthor() {
        return decoratedPublication.getAuthor();
    }

    @Override
    public String getTitle() {
        return decoratedPublication.getTitle();
    }

    @Override
    public int getNumberOfPages() {
        return decoratedPublication.getNumberOfPages();
    }

    @Override
    public String toString() {
        return decoratedPublication.toString();
    }

    protected void updateMembers(){
        this.hasCover = ((BookDecorator) decoratedPublication).hasCover;
        this.hasDustCover = ((BookDecorator) decoratedPublication).hasDustCover;
        this.hasAutograph = ((BookDecorator) decoratedPublication).hasAutograph;
    }

}

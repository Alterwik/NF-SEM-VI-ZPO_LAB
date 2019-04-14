package Decorator;

import Book.Publication;

public class BookWithSimpleCover extends BookDecorator implements BookWithCover{

    public BookWithSimpleCover(Publication decoratedPublication) throws WrongUsageOfBookDecoratorException {
        super(decoratedPublication);
        if(decoratedPublication instanceof BookWithCover) {
            throw new WrongUsageOfBookDecoratorException("wyjątek! Okładka może być tylko jedna");
        }
        if(decoratedPublication instanceof BookDecorator){
            updateMembers();
            if(((BookDecorator) decoratedPublication).hasCover == true) {
                throw new WrongUsageOfBookDecoratorException("wyjątek! Okładka może być tylko jedna");
            }
        }
        this.hasCover = true;
    }

    @Override
    public String toString() {
        return super.toString().concat(" | Okładka zwykła |");
    }
}

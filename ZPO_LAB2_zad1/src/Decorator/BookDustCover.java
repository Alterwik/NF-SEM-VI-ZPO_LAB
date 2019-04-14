package Decorator;

import Book.Publication;

public class BookDustCover extends BookDecorator implements BookWithCover{
    public BookDustCover(Publication decoratedPublication) throws WrongUsageOfBookDecoratorException {
        super(decoratedPublication);
        if(decoratedPublication instanceof BookDustCover ) {
            updateMembers();
            throw new WrongUsageOfBookDecoratorException("wyjątek! Obwoluta może być tylko jedna");
        }
        if(decoratedPublication instanceof BookDecorator) {
            updateMembers();
            if(((BookDecorator) decoratedPublication).hasDustCover == true){
                throw new WrongUsageOfBookDecoratorException("wyjątek! Obwoluta może być tylko jedna");
            }
        }
        if(decoratedPublication instanceof Publication && !(decoratedPublication instanceof BookDecorator)){
            throw new WrongUsageOfBookDecoratorException(
                    "wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki");
        }
        this.hasDustCover = true;
    }

    @Override
    public String toString() {
        return super.toString().concat(" Z obwolutą |");
    }
}

package Decorator;

import Book.Publication;

public class BookDustCover extends BookDecorator{
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
//            }else if (((Decorator.BookDecorator) decoratedPublication).hasCover == false){
//                throw new Decorator.WrongUsageOfBookDecoratorException(
//                        "wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki");
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

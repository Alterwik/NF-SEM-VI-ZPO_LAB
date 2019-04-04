package Decorator;

import Book.Publication;

public class BookWithAutograph extends BookDecorator{

    private String autograph;

    public BookWithAutograph(Publication decoratedPublication, String autograph) throws WrongUsageOfBookDecoratorException {
        super(decoratedPublication);
        if(decoratedPublication instanceof BookWithAutograph){
            updateMembers();
            throw new WrongUsageOfBookDecoratorException("wyjątek! Autograf może być tylko jeden");
        }
        if(decoratedPublication instanceof BookDecorator){
            updateMembers();
            if(((BookDecorator) decoratedPublication).hasAutograph == true) {
                throw new WrongUsageOfBookDecoratorException("wyjątek! Autograf może być tylko jeden");
            }
        }
        this.hasAutograph = true;
        this.autograph = autograph;
    }

    @Override
    public String toString() {
        return super.toString().concat(" "+autograph+" |");
    }
}

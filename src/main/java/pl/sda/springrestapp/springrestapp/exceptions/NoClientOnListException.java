package pl.sda.springrestapp.springrestapp.exceptions;

public class NoClientOnListException extends RuntimeException {
    public NoClientOnListException(String name){
        super("There is no client "+name+" on list.");
    }
}

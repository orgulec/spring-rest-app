package pl.sda.springrestapp.springrestapp.exceptions;

public class NoCarOnListException extends RuntimeException {
    public NoCarOnListException(String number){
        super("There is no car on list: " + number);
    }
}

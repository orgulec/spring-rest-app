package pl.sda.springrestapp.springrestapp.exceptions;

public class AlreadyOnListException extends RuntimeException {
    public AlreadyOnListException(String registr){
        super(String.format("Car [%s] is already exist!", registr));
    }
}

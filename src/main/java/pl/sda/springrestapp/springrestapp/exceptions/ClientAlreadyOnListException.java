package pl.sda.springrestapp.springrestapp.exceptions;

import org.hibernate.validator.constraints.pl.PESEL;

public class ClientAlreadyOnListException extends RuntimeException {
    public ClientAlreadyOnListException(@PESEL String pesel) {
        super("Client with PESEL: "+pesel+" is already on list.");
    }
}

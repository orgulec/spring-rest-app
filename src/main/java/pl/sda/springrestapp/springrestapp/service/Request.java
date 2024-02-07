package pl.sda.springrestapp.springrestapp.service;

import lombok.Data;
@Data
public class Request {
    private String brand;
    private String model;
//ta klasa służy tylko przechwytywaniu 2 parametrów przekazywanych w body o usunięcia elementu z listy
}

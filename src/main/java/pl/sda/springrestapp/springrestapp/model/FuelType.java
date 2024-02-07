package pl.sda.springrestapp.springrestapp.model;

public enum FuelType {
    DIESEL("diesel"),
    GAS("gas"),
    ELECTRIC("electric"),
    LPG("lpg");

    private final String name;

    FuelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

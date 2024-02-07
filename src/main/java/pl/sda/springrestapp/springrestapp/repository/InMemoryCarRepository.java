package pl.sda.springrestapp.springrestapp.repository;

import pl.sda.springrestapp.springrestapp.exceptions.AlreadyOnListException;
import pl.sda.springrestapp.springrestapp.exceptions.NoCarOnListException;
import pl.sda.springrestapp.springrestapp.model.Car;
import pl.sda.springrestapp.springrestapp.model.FuelType;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

//@Repository
public class InMemoryCarRepository implements CarRepository{

    private static Map<String, Car> carMap;

    static {
        carMap = new HashMap<>();
        carMap.put("ABC1234", Car.builder()
                .brand("Audi")
                .model("A6")
                .productionYear(2014)
                .fuelType(FuelType.DIESEL)
                .carValue(new BigDecimal("50000"))
                .build());
        carMap.put("JISD3456", Car.builder()
                .brand("VW")
                .model("Passat")
                .productionYear(2015)
                .fuelType(FuelType.GAS)
                .carValue(new BigDecimal("35000"))
                .build());
        carMap.put("JHPO87676", Car.builder()
                .brand("Skoda")
                .model("Octavia")
                .productionYear(2014)
                .fuelType(FuelType.LPG)
                .carValue(new BigDecimal("30000"))
                .build());
        carMap.put("JHPHG7676", Car.builder()
                .brand("Hyundai")
                .model("i30")
                .productionYear(2012)
                .fuelType(FuelType.GAS)
                .carValue(new BigDecimal("45000"))
                .build());
        carMap.put("EPHG43676", Car.builder()
                .brand("Tesla")
                .model("S3")
                .productionYear(2018)
                .fuelType(FuelType.ELECTRIC)
                .carValue(new BigDecimal("150000"))
                .build());
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carMap.values());
    }

    @Override
    public Optional<Car> gatCarByRegistr(String registr) {
        if(!carMap.containsKey(registr)) {
            throw new NoCarOnListException(registr);
        }
        return Optional.ofNullable(carMap.get(registr));
    }

    @Override
    public List<Car> addCar(String registr, Car newCar) {
        if(!carMap.containsKey(registr)) {
            carMap.put(registr, newCar);
            return new ArrayList<>(carMap.values());
        } else return null;
    }

    @Override
    public List<Car> addCar2(String registr, Car newCar) {
        if(carMap.containsKey(registr)) {
            throw new AlreadyOnListException(registr);
        }
        return new ArrayList<>(carMap.values());

    }

    @Override
    public List<Car> editCarValue(String registr, BigDecimal carValue) {
        Optional<Car> car = Optional.ofNullable(carMap.get(registr));
        if(car.isEmpty()){
//            car.get().setCarValue(carValue);
            throw new NoCarOnListException(registr);
        }
        else {
            car.get().setCarValue(carValue);
        }
        return new ArrayList<>(carMap.values());
    }

    @Override
    public List<Car> editCar(String registr, Car editedCar) {
        Optional<Car> car = Optional.ofNullable(carMap.get(registr));
        car.ifPresent(value -> carMap.replace(registr, value, editedCar));
//        if(car.isPresent()){
//            carMap.replace(registr,car.get(),editedCar);
//        }
        return new ArrayList<>(carMap.values());
    }

    @Override
    public List<Car> getCarsByYear(int fromYear, int toYear) {
        List<Car> carList = carMap.values()
                .stream()
                .filter(car -> car.getProductionYear() >= fromYear)
                .filter(car -> car.getProductionYear() <= toYear)
                .collect(Collectors.toList());
        if(carList.isEmpty()){
            throw new NoCarOnListException("");
        }
        return carList;
    }

    @Override
    public List<Car> getCarsByFuel(String fuel) {
        List<Car> carList = carMap.values()
                .stream()
                .filter(car ->
                        String.valueOf(car.getFuelType()).equalsIgnoreCase(fuel)
                ).collect(Collectors.toList());
        if(carList.isEmpty()){
            throw new NoCarOnListException("");
        }
        return carList;
    }

    @Override
    public List<Car> deleteCarByRegistr(String registr) {
        Optional<Car> car = Optional.ofNullable(carMap.get(registr));
        if(car.isPresent()){
            carMap.remove(registr);
        }
        return new ArrayList<>(carMap.values());
    }

    @Override
    public List<Car> deleteCarByBrandAndMark(String brand, String model) {
//        carMap.entrySet()
//                .stream()
//                .filter(c -> !c.getValue().getBrand().equalsIgnoreCase(car.getBrand()) && !c.getValue().getModel().equalsIgnoreCase(car.getModel()))
//                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//        return new ArrayList<>(carMap.values());

        carMap.entrySet().removeIf(c -> c.getValue().getBrand().equals(brand) && c.getValue().getModel().equals(model));
        return new ArrayList<>(carMap.values());
    }


}

package pl.sda.springrestapp.springrestapp.repository;

import org.springframework.stereotype.Repository;
import pl.sda.springrestapp.springrestapp.model.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository {
    List<Car> getAllCars();
    Optional<Car> gatCarByRegistr(String registr);
    List<Car> addCar(String registr, Car newCar);
    List<Car> addCar2(String registr, Car newCar);
    List<Car> editCarValue(String registr, BigDecimal carValue);
    List<Car> editCar(String registr, Car editedCar);
    List<Car> getCarsByYear(int fromYear, int toYear);
    List<Car> getCarsByFuel(String fuel);
    List<Car> deleteCarByRegistr(String registr);
    List<Car> deleteCarByBrandAndMark(String brand, String model);
}

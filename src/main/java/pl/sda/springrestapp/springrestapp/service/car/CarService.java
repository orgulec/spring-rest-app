package pl.sda.springrestapp.springrestapp.service;

import org.springframework.stereotype.Service;
import pl.sda.springrestapp.springrestapp.model.Car;
import pl.sda.springrestapp.springrestapp.repository.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.getAllCars();
    }
    public Optional<Car> getCarByRegistr(String registr){
        return carRepository.gatCarByRegistr(registr);
    }

    public List<Car> addCar(String registr, Car newCar){
        return carRepository.addCar(registr, newCar);
    }
    public List<Car> editCarValue(String registr, BigDecimal carValue){
        return carRepository.editCarValue(registr, carValue);
    }
    public List<Car> editedCar(String registr, Car editedCar){
        return carRepository.editCar(registr, editedCar);
    }
    public List<Car> getCarsByYear(int fromYear, int toYear){
        return carRepository.getCarsByYear(fromYear, toYear);
    }
    public List<Car> getCarsByFuel(String fuel){
        return carRepository.getCarsByFuel(fuel);
    }
    public List<Car> deleteCarByRegistr(String registr){
        return carRepository.deleteCarByRegistr(registr);
    }
    public List<Car> deleteCarByBrandAndMark(String brand, String model) {
        return carRepository.deleteCarByBrandAndMark(brand, model);
    }
}

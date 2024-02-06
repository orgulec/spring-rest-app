package repository;

import org.springframework.stereotype.Repository;
import pl.sda.springrestapp.springrestapp.model.Car;

import java.util.List;
@Repository
public interface CarRepository {
    List<Car> getAllCars();
}

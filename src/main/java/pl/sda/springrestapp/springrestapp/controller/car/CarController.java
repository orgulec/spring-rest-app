package pl.sda.springrestapp.springrestapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springrestapp.springrestapp.model.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController{

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> listOfCars(){
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }
    @GetMapping("/car/{registr}")       //dane ze zmienną ścieżką
    public ResponseEntity<Car> withPathVariable(@PathVariable String registr){
        Optional<Car> carByRegistr = carService.getCarByRegistr(registr);
        return carByRegistr.map(optCar -> ResponseEntity.ok(optCar)).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).body(Car.builder().build()));
    }

    @GetMapping("/number")       //dane ze zmienną ścieżką
    public ResponseEntity<Car> withRequestParam(@RequestParam String registr){
        Optional<Car> carByRegistr = carService.getCarByRegistr(registr);
        return carByRegistr.map(
                optCar -> ResponseEntity.ok(optCar)).orElse(null);
    }

    @PostMapping("/{number}")
    public ResponseEntity<List<Car>> addCar(@PathVariable String number, @RequestBody Car car){ //podajemy json w RequestBody jako pola Car
        return ResponseEntity.ok(carService.addCar(number, car));
    }

    @PatchMapping("/edit/{number}")
    public ResponseEntity<List<Car>> editCar(@PathVariable String number, @RequestBody Car car){
        return ResponseEntity.ok(carService.editedCar(number, car));
    }
    @PatchMapping("/editValue/{number}")
    public ResponseEntity<List<Car>> editCarValue(@PathVariable String number, @RequestParam BigDecimal carValue){   //przy przekazaniu tylko BigDecimala podajemy samą liczbę (bez opakowania)!!!
        return ResponseEntity.ok(carService.editCarValue(number, carValue));
    }

    @PatchMapping("/editValue2/{number}")
    public ResponseEntity<List<Car>> editCarValue2(@PathVariable String number, @RequestBody BigDecimal carValue){
        return ResponseEntity.ok(carService.editCarValue(number, carValue));
    }

    @GetMapping("/findCars")       //dane ze zmienną ścieżką
    public ResponseEntity<List<Car>> findByYear(@RequestParam Integer from, @RequestParam Integer to){
        return ResponseEntity.ok(carService.getCarsByYear(from, to));
    }

    @GetMapping("/findByFuel/{fuel}")
    public ResponseEntity<List<Car>> findCarsByFuel(@PathVariable String fuel){
        return ResponseEntity.ok(carService.getCarsByFuel(fuel));
    }
    @DeleteMapping("/delete/{registr}")       //dane ze zmienną ścieżką
    public ResponseEntity<List<Car>> deleteByRegistr(@PathVariable String registr){
        return ResponseEntity.ok(carService.deleteCarByRegistr(registr));

    }
    @DeleteMapping("/deleteByBrandAndModel")
    public ResponseEntity<List<Car>> deleteCarByBrandAndMark(@RequestBody Request request){
        return ResponseEntity.ok(carService.deleteCarByBrandAndMark(request.getBrand(),request.getModel()));
    }

}

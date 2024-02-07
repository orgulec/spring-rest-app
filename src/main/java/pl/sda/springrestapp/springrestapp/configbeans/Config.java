package pl.sda.springrestapp.springrestapp.configbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.springrestapp.springrestapp.repository.CarRepository;
import pl.sda.springrestapp.springrestapp.repository.InMemoryCarRepository;
import pl.sda.springrestapp.springrestapp.service.car.CarService;

@Configuration
public class Config {
    //po wywaleniu adnotacji Beanów (stereotypów) z klasy InMemoryCarRepository i CarService musimy tu stworzyć konfigurację dla tych klas aby Spring je wczytał
    @Bean
    public CarRepository carRepository(){
        return new InMemoryCarRepository();
    }
    @Bean
    public CarService carService(CarRepository carRepository){
        return new CarService(carRepository);
    }


}

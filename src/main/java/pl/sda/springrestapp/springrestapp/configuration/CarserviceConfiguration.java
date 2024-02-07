package pl.sda.springrestapp.springrestapp.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
@Data
public class CarserviceConfiguration {

    @Value("${carservice.configuration.owner}")
    private String owner;
    @Value("${carservice.configuration.name}")
    private String name;
    @Value("${carservice.configuration.year}")
    private int year;

    public void showCarserviceDataFromProperties(){
        System.out.printf("Owner: [%s], Carservice name: [%s], Year of establish: [%s]", owner, name, year);
    }

}

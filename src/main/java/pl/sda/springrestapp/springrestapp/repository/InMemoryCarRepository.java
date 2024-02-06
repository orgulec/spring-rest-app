package repository;

import org.springframework.stereotype.Repository;
import pl.sda.springrestapp.springrestapp.model.Car;
import pl.sda.springrestapp.springrestapp.model.FuelType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class InMemoryCarRepository implements CarRepository{
    private static final Map<String, Car> carMap;

    static {
        carMap = new HashMap<>();
        carMap.put("ABC1234", Car.builder()
                .brand("Audi")
                .model("A6")
                .productionYear(2014)
                .felType(FuelType.DIESEL)
                .carValue(new BigDecimal("50000"))
                .build());
        carMap.put("JISD3456", Car.builder()
                .brand("VW")
                .model("Passat")
                .productionYear(2015)
                .felType(FuelType.GAS)
                .carValue(new BigDecimal("35000"))
                .build());
        carMap.put("JHPO87676", Car.builder()
                .brand("Skoda")
                .model("Octavia")
                .productionYear(2014)
                .felType(FuelType.LPG)
                .carValue(new BigDecimal("30000"))
                .build());
        carMap.put("JHPHG7676", Car.builder()
                .brand("Hyundai")
                .model("i30")
                .productionYear(2012)
                .felType(FuelType.GAS)
                .carValue(new BigDecimal("45000"))
                .build());
        carMap.put("EPHG43676", Car.builder()
                .brand("Tesla")
                .model("S3")
                .productionYear(2018)
                .felType(FuelType.ELECTRIC)
                .carValue(new BigDecimal("150000"))
                .build());
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carMap.values());
    }
}

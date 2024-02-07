package pl.sda.springrestapp.springrestapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
public class Car {
    @NotNull(message = "Model cannot by null")
    private String model;

    @Size(min=2,max=8)
    private String brand;

    @Range(min=500, max=1_000_000)
    private BigDecimal carValue;

    @Min(2000)
    @Max(2025)
    private Integer productionYear;

    private FuelType fuelType;
}

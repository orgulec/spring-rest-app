package pl.sda.springrestapp.springrestapp.client;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
@Data
public class Client {
    @Size(min=2)
    private String firstName;

    @Size(min=2)
    private String lastName;

    @Email
    private String email;

    @Size(min=9, max=12)
    private String phoneNumber;

    private LocalDate dateOfBirth;

    @PESEL
    private String pesel;

    @AssertTrue
    private boolean isPremium;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return isPremium == client.isPremium && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(email, client.email) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(dateOfBirth, client.dateOfBirth) && Objects.equals(pesel, client.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, dateOfBirth, pesel, isPremium);
    }
}


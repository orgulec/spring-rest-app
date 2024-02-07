package pl.sda.springrestapp.springrestapp.repository;

import pl.sda.springrestapp.springrestapp.client.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAllClients();
    List<Client> getClientsByName(String name);
    Optional<Client> getClientsByFirstNameAndLastName(String firstname, String lastname);
    Client getClientById(Integer id);
    Client getClientByPesel(String pesel);
    List<Client> addClient(Client client);
    Client edtitClientPhoneNumberById(Integer id, String phoneNumber);
    Client edtitClientById(Integer id, Client client);
    List<Client> deleteClientById(Integer id);
    Client changeClientStatusById(Integer id, boolean status);

}

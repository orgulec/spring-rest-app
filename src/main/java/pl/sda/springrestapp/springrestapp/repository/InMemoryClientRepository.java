package pl.sda.springrestapp.springrestapp.repository;

import org.springframework.stereotype.Repository;
import pl.sda.springrestapp.springrestapp.client.Client;
import pl.sda.springrestapp.springrestapp.exceptions.ClientAlreadyOnListException;
import pl.sda.springrestapp.springrestapp.exceptions.NoClientOnListException;

import java.time.LocalDate;
import java.util.*;
@Repository
public class InMemoryClientRepository implements ClientRepository{

    private static Map<Integer, Client> clientDb;
    private static Integer ID = 0;

    static {
        clientDb = new HashMap<>();
        clientDb.put(ID++, Client.builder()
                        .firstName("Janek")
                        .lastName("Kos")
                        .email("jankos@gm.pl")
                        .dateOfBirth(LocalDate.of(1999, 6,11))
                        .pesel("95258078531L")
                        .phoneNumber("+485327015")
                        .isPremium(true)
                        .build());
        clientDb.put(ID++, Client.builder()
                        .firstName("Grzegoż")
                        .lastName("Brzęczyszczykiewicz")
                        .email("grzbrz@wp.pl")
                        .dateOfBirth(LocalDate.of(1970,3,15))
                        .pesel("84268078531L")
                        .phoneNumber("48126321570")
                        .isPremium(true)
                        .build());
        clientDb.put(ID++, Client.builder()
                        .firstName("Franc")
                        .lastName("Kafka")
                        .email("franck@onet.pl")
                        .dateOfBirth(LocalDate.of(1966,11,22))
                        .pesel("31795178531L")
                        .phoneNumber("48226493518")
                        .isPremium(true)
                        .build());
    }

    @Override
    public List<Client> getAllClients() {
        return new ArrayList<>(clientDb.values());
    }

    @Override
    public List<Client> getClientsByName(String name) {
        List<Client> clients = clientDb.values().stream()
                .filter(cl -> cl.getFirstName().equalsIgnoreCase(name))
                .toList();
        if(clients.isEmpty()){
            throw new NoClientOnListException(name);
        }
        return clients;
    }

    @Override
    public Optional<Client> getClientsByFirstNameAndLastName(String firstname, String lastname) {
        Optional<Client> client = clientDb.values().stream()
                .filter(cl -> cl.getFirstName().equalsIgnoreCase(firstname))
                .filter(cl -> cl.getLastName().equalsIgnoreCase(lastname))
                .findFirst();
        if(client.isEmpty()){
            throw new NoClientOnListException(firstname+" "+lastname);
        }
        return client;
    }

    @Override
    public Client getClientById(Integer id) {
        if(!clientDb.containsKey(id)) {
            throw new NoClientOnListException("ID: "+id);
        }
        return clientDb.get(id);
    }
    @Override
    public Client getClientByPesel(String pesel) {
        Optional<Client> client = clientDb.values().stream()
                .filter(cl -> cl.getPesel().equals(pesel))
                .findFirst();
        if(client.isEmpty()){
            throw new NoClientOnListException("Pesel: "+pesel);
        }
        return client.get();
    }

    @Override
    public List<Client> addClient(Client client) {
        if(clientDb.containsValue(client)){
            throw new ClientAlreadyOnListException(client.getPesel());
        }
        clientDb.put(ID++,client);
        return new ArrayList<>(clientDb.values());
    }

    @Override
    public Client edtitClientPhoneNumberById(Integer id, String phoneNumber) {
        if(!clientDb.containsKey(id)) {
            throw new NoClientOnListException("ID: "+id);
        }
        Client client = clientDb.get(id);
        client.setPhoneNumber(phoneNumber);
        return client;
    }
    @Override
    public Client edtitClientById(Integer id, Client client){
        if(!clientDb.containsKey(id)) {
            throw new NoClientOnListException("ID: "+id);
        }
        Client clientFromList = clientDb.get(id);
        if(client.getFirstName()!=null)    { clientFromList.setFirstName(client.getFirstName());}
        if(client.getLastName()!=null)    { clientFromList.setLastName(client.getLastName());}
        if(client.getEmail()!=null)    { clientFromList.setEmail(client.getEmail());}
        if(client.getPhoneNumber()!=null)    { clientFromList.setPhoneNumber(client.getPhoneNumber());}
        if(client.getPesel()!=null)    { clientFromList.setPesel(client.getPesel());}
        return  clientFromList;
    }
    @Override
    public Client changeClientStatusById(Integer id, boolean status){
        if(!clientDb.containsKey(id)) {
            throw new NoClientOnListException("ID: "+id);
        }
        Client client = clientDb.get(id);
        client.setPremium(status);
        return client;
    }
    @Override
    public List<Client> deleteClientById(Integer id) {
        if(!clientDb.containsKey(id)) {
            throw new NoClientOnListException("ID: "+id);
        }
        clientDb.remove(id);
        return new ArrayList<>(clientDb.values());
    }
}

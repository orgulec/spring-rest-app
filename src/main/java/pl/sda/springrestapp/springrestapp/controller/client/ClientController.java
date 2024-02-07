package pl.sda.springrestapp.springrestapp.controller.client;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springrestapp.springrestapp.client.Client;
import pl.sda.springrestapp.springrestapp.repository.InMemoryClientRepository;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    public final InMemoryClientRepository clientsDb;
    @GetMapping("/all")
        public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientsDb.getAllClients());
    }
    @PostMapping("/addNew")
        public ResponseEntity<Client> addNewClient(@RequestBody @Valid Client client){
        log.info("Adding Client: "+client);
        return ResponseEntity.ok(Client.builder().build());
    }
    @PostMapping("/add")
    public ResponseEntity<List<Client>> addClient(@RequestBody @Valid Client client){
        List<Client> newClientsDb = clientsDb.addClient(client);
        log.info("Adding Client: "+client);
        return ResponseEntity.ok(newClientsDb);
    }
    @GetMapping("/findByName/{name}")
        public ResponseEntity<List<Client>> getClientsByName(@PathVariable String name){
        return ResponseEntity.ok(clientsDb.getClientsByName(name));
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Client> getClientsById(@PathVariable Integer id){
        return ResponseEntity.ok(clientsDb.getClientById(id));
    }
    @GetMapping("/findByPesel/{pesel}")
    public ResponseEntity<Client> getClientsByPesel(@PathVariable @Valid String pesel){
        return ResponseEntity.ok(clientsDb.getClientByPesel(pesel));
    }
    @GetMapping("/findBy/")
        public ResponseEntity<Client> getClientsByFirstNameAndLastName(@RequestParam @Valid String firstname, String lastname){
        return ResponseEntity.ok(clientsDb.getClientsByFirstNameAndLastName(firstname, lastname).get());
    }
    @PostMapping("/editPhoneById")
        public ResponseEntity<Client> edtitClientPhoneById(@RequestParam Integer id, @RequestParam String phoneNumber){
        log.info("Editing phone Client: "+id);
        return ResponseEntity.ok(clientsDb.edtitClientPhoneNumberById(id, phoneNumber));
    }
    @PatchMapping("/editClientById/{id}")
    public ResponseEntity<Client> editClientById(@PathVariable Integer id, @RequestBody Client clientData){
        log.info("Editing Client data: "+id);
        return ResponseEntity.ok(clientsDb.edtitClientById(id, clientData));
    }
    @PatchMapping("/changeStatusById")
    public ResponseEntity<Client> changeStatusById(@RequestParam Integer id, boolean status){
        log.info("Changing Client status: "+id);
        return ResponseEntity.ok(clientsDb.changeClientStatusById(id, status));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<List<Client>> deleteClientById(@RequestParam Integer id){
        log.info("Deleting Client: "+id);
        return ResponseEntity.ok(clientsDb.deleteClientById(id));
    }

}

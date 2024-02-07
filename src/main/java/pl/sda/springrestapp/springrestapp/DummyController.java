package pl.sda.springrestapp.springrestapp;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.springrestapp.springrestapp.configuration.WorkshopConfiguration;
import pl.sda.springrestapp.springrestapp.configuration.WorkshopInfo;

import java.time.LocalDate;

//@Controller
@RestController // @Controller + @ResponseBody
@RequestMapping("/dummy")
public class DummyController {

    private final WorkshopInfo workshopInfo;
    private final WorkshopConfiguration workshopConfiguration;

    public DummyController(WorkshopInfo workshopInfo, WorkshopConfiguration workshopConfiguration) {
        this.workshopInfo = workshopInfo;
        this.workshopConfiguration = workshopConfiguration;
    }

    // WSZYSTKO TO SPRAWDZAMY W POSTMANIE - PODAJĄC localhost:8080/... !!!
    @GetMapping
//    @ResponseBody   //dodajemy bo używamy samego @Controllera na górze - konieczne do wyświetlenia adresu w body
    public LocalDate getDate() {
        return LocalDate.now();
    }
    @PostMapping
    public ResponseEntity<String> post(){
        return ResponseEntity.ok("Hello from post method!");
    }
    @PutMapping
    public ResponseEntity<String> put(){
        return ResponseEntity.ok("Hello from put method!");
    }

    @PatchMapping
    public ResponseEntity<String> patch(){
        return ResponseEntity.ok("Hello from patch method!");
    }
    @DeleteMapping
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok("Hello from delete method!");
    }

    @GetMapping("/500")
    public ResponseEntity<String> return500(){
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/400")
    public ResponseEntity<Void> return400(){
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/notFound")
    public ResponseEntity<Void> notFound(){
//        return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/header")
    public ResponseEntity<String> withHeader(@RequestHeader("my-header") String myHeader){ //tu przekazujemy dane w nagłówku
        return ResponseEntity.ok("Hello with header value: "+ myHeader);
    }
    @GetMapping("/header2")
    public ResponseEntity<String> withHeader2(@RequestHeader("my-header") String myHeader){ //tu przekazujemy dane w nagłówku - konwersja nazwy myHeader == my-header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-header", "My custom header2 value");
        return new ResponseEntity<>("Hello with header2 value: " + myHeader, headers, 200);
    }

    @GetMapping("/path/{id}")       //dane ze zmienną ścieżką
    public ResponseEntity<String> withPathVariable(@PathVariable String id){
        return ResponseEntity.ok("Otrzymany id od klienta = " + id);
    }
    @GetMapping("/path")       //dane ze zmienną ścieżką
    public ResponseEntity<String> withRequestParam(@RequestParam String parametr1, @RequestParam String parametr2){
        return ResponseEntity.ok("Otrzymane parametry od klienta = " + parametr1 + parametr2);
    }


    @GetMapping("/workshop")
    public ResponseEntity<Void> showConfigsInConsole(){
        workshopInfo.showDataFromProperties();
        return ResponseEntity.ok().build(); //printuje tylko na console a nie w postmanie
    }
    @GetMapping("/config")
    public ResponseEntity<Void> showConfigsInConsole2(){
        workshopConfiguration.showDataFromProperties();
        return ResponseEntity.ok().build(); //printuje tylko na console a nie w postmanie
    }
}

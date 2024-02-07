package pl.sda.springrestapp.springrestapp.controller.commercial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springrestapp.springrestapp.service.commercial.CommercialService;

@RestController
@RequestMapping("/commercial")
@RequiredArgsConstructor
public class CommercialController {

    private final CommercialService commercialService;

    //użycie Qualifiera
//    public CommercialController(@Qualifier("businessCustomerCommercialService") CommercialService commercialService) {
//        this.commercialService = commercialService;
//    }

    @PostMapping
    public ResponseEntity<Void> sendCommercial(@RequestBody String content){
        commercialService.sendCommercialOffer(content);
        return ResponseEntity.ok().build();
    }

}

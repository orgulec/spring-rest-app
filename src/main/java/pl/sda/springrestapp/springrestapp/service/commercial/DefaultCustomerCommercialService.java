package pl.sda.springrestapp.springrestapp.service.commercial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
//@Primary  //pierwszeństwo odpalania interfejsu
@Profile("!prod")
public class DefaultCustomerCommercialService implements CommercialService {
    @Override
    public void sendCommercialOffer(String commercialContent) {
        log.info("It's an offer for default customers: " + commercialContent);
    }
}

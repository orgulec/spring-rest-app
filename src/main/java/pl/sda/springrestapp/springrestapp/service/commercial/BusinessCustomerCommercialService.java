package pl.sda.springrestapp.springrestapp.service.commercial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("prod")

public class BusinessCustomerCommercialService implements CommercialService {
    @Override
    public void sendCommercialOffer(String commercialContent) {
        log.info("It's an offer fo business customers: "+ commercialContent);
    }
}

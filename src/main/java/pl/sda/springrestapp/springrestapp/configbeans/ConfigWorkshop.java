package pl.sda.springrestapp.springrestapp.configbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.springrestapp.springrestapp.configuration.WorkshopInfo;

@Configuration
public class ConfigWorkshop {

    @Bean
    public WorkshopInfo workshopInfo(){
        return new WorkshopInfo();
    }
}

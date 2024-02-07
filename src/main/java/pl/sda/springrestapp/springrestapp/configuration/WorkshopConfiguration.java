package pl.sda.springrestapp.springrestapp.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "workshop.info")
@Setter
public class WorkshopConfiguration {
    private String author;
    private String name;

    public void showDataFromProperties(){
        System.out.printf("Author: [%s], workshop name: [%s]", author, name);
    }
}

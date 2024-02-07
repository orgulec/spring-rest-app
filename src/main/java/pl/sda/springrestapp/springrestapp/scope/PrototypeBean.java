package pl.sda.springrestapp.springrestapp.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    private final Integer hashCode;

    public PrototypeBean() {
        this.hashCode = this.hashCode();
    }

    public Integer showHashCode(){
        return hashCode;
    }
}

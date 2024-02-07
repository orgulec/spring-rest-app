package pl.sda.springrestapp.springrestapp.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")   //tego nie trzeba dopisywać, bo to domyślny typ scope !!!
public class SingletonBean {

    private final Integer hashCode;

    public SingletonBean() {
        this.hashCode = this.hashCode();
    }

    public Integer showHashCode(){
        return hashCode;
    }
}

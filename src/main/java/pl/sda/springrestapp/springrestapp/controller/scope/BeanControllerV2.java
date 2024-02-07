package pl.sda.springrestapp.springrestapp.controller.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springrestapp.springrestapp.scope.PrototypeBean;
import pl.sda.springrestapp.springrestapp.scope.RequestBean;
import pl.sda.springrestapp.springrestapp.scope.SingletonBean;

@RestController
@RequestMapping("/beans/v2")
@RequiredArgsConstructor
public class BeanControllerV2 {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;
    private final RequestBean requestBean;

    @GetMapping("/singleton")
    public ResponseEntity<Integer> showSingleton(){
        return ResponseEntity.ok(singletonBean.showHashCode());
    }
    @GetMapping("/prototype")
    public ResponseEntity<Integer> showPrototype(){
        return ResponseEntity.ok(prototypeBean.showHashCode());
    }
    @GetMapping("/request")
    public ResponseEntity<Integer> showRequest(){
        return ResponseEntity.ok(requestBean.showHashCode());
    }
}

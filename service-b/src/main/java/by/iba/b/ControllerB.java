package by.iba.b;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ControllerB {

    private RepositoryB repository = new RepositoryB();

    @GetMapping("/user")
    public Mono<User> getUser() {
        return Mono.just(repository.getUser());
    }
}

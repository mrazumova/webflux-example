package by.iba.a;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api")
public class ControllerA {

    @GetMapping("/user")
    public Flux<User> getUserList() {
        return fetchUserAndOtherUser();
    }

    public Flux<User> fetchUserAndOtherUser() {
        return Flux.merge(getUser("http://localhost:8080"), getUser("http://localhost:8090"))
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .sequential();
    }

    private Mono<User> getUser(String uri) {
        WebClient webClient = WebClient.create(uri);
        return webClient.get()
                .uri("/api/user")
                .retrieve()
                .bodyToMono(User.class);
    }
}

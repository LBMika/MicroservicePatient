package fr.mika.patient.repository;

import fr.mika.patient.dto.NurseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class WebNurseRepository {
    private WebClient webClient;

    public WebNurseRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<NurseDTO> getNurseById(String id) {
        Mono<NurseDTO> nurseDTO = webClient.get()
                .uri("/nurses/"+id)
                .retrieve()
                .bodyToMono(NurseDTO.class);
        return nurseDTO;
    }


    /*
    public Flux<Post> getPost() {
        Flux<Post> post = webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class);
        return post;
    }
    */
}

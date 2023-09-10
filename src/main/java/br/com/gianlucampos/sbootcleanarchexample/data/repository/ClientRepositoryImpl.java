package br.com.gianlucampos.sbootcleanarchexample.data.repository;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;
import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    @Value("${spring.server.url}")
    private String URL_SERVER;

    @Value("${spring.server.get-songs-url}")
    private String GET_SONGS_URL;

    private final RestTemplate restTemplate;

    @Override
    public Song retrieveSong(UUID id) {
        var url = UriComponentsBuilder.fromHttpUrl(URL_SERVER)
                .path(GET_SONGS_URL)
                .build()
                .toUriString();

        Map<String, String> params = Collections.singletonMap("id", String.valueOf(id));

        try {
            var obj = restTemplate.getForEntity(url, SongDTO.class, params);
            return Objects.requireNonNull(obj.getBody()).toDomain();
        } catch (Exception exception) {
            log.error("Fail at retrieving song info from server. Id {}", id, exception);
            throw exception;
        }
    }
}

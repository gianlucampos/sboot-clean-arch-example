package br.com.gianlucampos.sbootcleanarchexample.application.config;

import br.com.gianlucampos.sbootcleanarchexample.data.repository.ClientRepositoryImpl;
import br.com.gianlucampos.sbootcleanarchexample.data.repository.JpaSongDatasource;
import br.com.gianlucampos.sbootcleanarchexample.data.repository.SongRepositoryImpl;
import br.com.gianlucampos.sbootcleanarchexample.data.service.ClientServiceImpl;
import br.com.gianlucampos.sbootcleanarchexample.data.service.SongServiceImpl;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.ClientRepository;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.SongRepository;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.ClientService;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.SongService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public SongService songService(SongRepository songRepository) {
        return new SongServiceImpl(songRepository);
    }

    @Bean
    public SongRepository songRepository(JpaSongDatasource jpaSongDatasource) {
        return new SongRepositoryImpl(jpaSongDatasource);
    }

    @Bean
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientServiceImpl(clientRepository);
    }

    @Bean
    public ClientRepository clientRepository(RestTemplate restTemplate) {
        return new ClientRepositoryImpl(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

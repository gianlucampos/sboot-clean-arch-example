package br.com.gianlucampos.sbootcleanarchexample.application.config;

import br.com.gianlucampos.sbootcleanarchexample.data.repository.JpaSongDatasource;
import br.com.gianlucampos.sbootcleanarchexample.data.repository.SongRepositoryImpl;
import br.com.gianlucampos.sbootcleanarchexample.data.service.SongServiceImpl;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.SongRepository;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.SongService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}

package br.com.gianlucampos.sbootcleanarchexample.data.repository;

import br.com.gianlucampos.sbootcleanarchexample.data.models.SongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaSongDatasource extends JpaRepository<SongModel, UUID> {

}

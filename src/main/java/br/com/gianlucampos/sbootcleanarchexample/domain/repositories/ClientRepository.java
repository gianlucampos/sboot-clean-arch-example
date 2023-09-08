package br.com.gianlucampos.sbootcleanarchexample.domain.repositories;

import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;

import java.util.UUID;

public interface ClientRepository {

    Song retrieveSong(UUID id);

}

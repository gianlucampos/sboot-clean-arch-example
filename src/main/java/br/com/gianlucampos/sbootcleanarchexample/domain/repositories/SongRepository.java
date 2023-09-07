package br.com.gianlucampos.sbootcleanarchexample.domain.repositories;

import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;

import java.util.UUID;

public interface SongRepository {

    Song retrieveSong(UUID id);

    void saveSong(Song song);

    void deleteSong(UUID id);

}

package br.com.gianlucampos.sbootcleanarchexample.domain.repositories;

import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;

public interface SongRepository {

    Song retrieveSong(String id);

    void saveSong(Song song);

    void deleteSong(String id);

}

package br.com.gianlucampos.sbootcleanarchexample.domain.services;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;

public interface SongService {

    SongDTO retrieveSong(String id);

    void saveSong(SongDTO song);

    void deleteSong(String id);

}

package br.com.gianlucampos.sbootcleanarchexample.domain.services;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;

public interface ClientService {

    SongDTO retrieveSong(String id);

}

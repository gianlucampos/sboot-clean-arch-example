package br.com.gianlucampos.sbootcleanarchexample.data.service;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.ClientRepository;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.ClientService;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public SongDTO retrieveSong(String id) {
        var song = clientRepository.retrieveSong(UUID.fromString(id));
        return new SongDTO(song);
    }
}

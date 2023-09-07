package br.com.gianlucampos.sbootcleanarchexample.data.service;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.SongRepository;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.SongService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public SongDTO retrieveSong(String id) {
        var song = songRepository.retrieveSong(id);
        return new SongDTO(song);
    }

    @Override
    public void saveSong(SongDTO song) {
        songRepository.saveSong(song.toDomain());
    }

    @Override
    public void deleteSong(String id) {
        songRepository.deleteSong(id);
    }
}

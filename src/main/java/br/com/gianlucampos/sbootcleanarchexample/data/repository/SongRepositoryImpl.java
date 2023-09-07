package br.com.gianlucampos.sbootcleanarchexample.data.repository;

import br.com.gianlucampos.sbootcleanarchexample.data.models.SongModel;
import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;
import br.com.gianlucampos.sbootcleanarchexample.domain.exceptions.ObjectNotFoundException;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

@AllArgsConstructor
public class SongRepositoryImpl implements SongRepository {

    private final JpaSongDatasource datasource;

    @Override
    public Song retrieveSong(UUID id) {
        return datasource.findById(id)
                .map(SongModel::toDomain)
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Object not found on database! Id: %s", id)));
    }

    @Override
    public void saveSong(Song song) {
        if (song.getId() == null) {
            datasource.save(new SongModel(song));
            return;
        }

        var songDatabase = datasource.findById(UUID.fromString(song.getId()));
        if (songDatabase.isPresent()) {
            var newSong = new SongModel(song);
            newSong.setId(songDatabase.get().getId());
            datasource.save(new SongModel(song));
        } else {
            datasource.save(new SongModel(song));
        }

    }

    @Override
    public void deleteSong(UUID id) {
        retrieveSong(id);
        try {
            datasource.deleteById(id);
        } catch (Exception ex) {
            throw new DataIntegrityViolationException(String.format("Invalid id to remove on database! Id: %s", id));
        }
    }
}

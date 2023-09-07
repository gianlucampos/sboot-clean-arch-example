package br.com.gianlucampos.sbootcleanarchexample.data.repository;

import br.com.gianlucampos.sbootcleanarchexample.data.models.SongModel;
import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;
import br.com.gianlucampos.sbootcleanarchexample.domain.repositories.SongRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SongRepositoryImpl implements SongRepository {

    private final JpaSongDatasource datasource;

    @Override
    public Song retrieveSong(String id) {
        return datasource.findById(id).orElse(new SongModel()).toDomain();
    }

    @Override
    public void saveSong(Song song) {
        if(song.getId() == null) {
            datasource.save(new SongModel(song));
            return;
        }

        var songDatabase = datasource.findById(song.getId());
        if (songDatabase.isPresent()) {
            var newSong = new SongModel(song);
            newSong.setId(songDatabase.get().getId());
            datasource.save(new SongModel(song));
        } else {
            datasource.save(new SongModel(song));
        }

    }

    @Override
    public void deleteSong(String id) {
        datasource.deleteById(id);
    }
}

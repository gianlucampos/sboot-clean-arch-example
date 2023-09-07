package br.com.gianlucampos.sbootcleanarchexample.application.dtos;

import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SongDTO {

    private String id;
    private String name;
    private String artist;
    private String album;

    public SongDTO(Song song) {
        this.id = song.getId();
        this.name = song.getName();
        this.artist = song.getArtist();
        this.album = song.getAlbum();
    }

    public Song toDomain() {
        return Song.builder()
            .id(this.id)
            .name(this.name)
            .album(this.album)
            .artist(this.artist)
            .build();
    }

}

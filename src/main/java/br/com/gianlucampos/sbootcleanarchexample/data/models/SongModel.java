package br.com.gianlucampos.sbootcleanarchexample.data.models;

import br.com.gianlucampos.sbootcleanarchexample.domain.entities.Song;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "song")
public class SongModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String name;
    @Column
    private String album;
    @Column
    private String artist;

    public SongModel(Song song) {
        this.id = song.getId() != null ? UUID.fromString(song.getId()) : null;
        this.name = song.getName();
        this.album = song.getAlbum();
        this.artist = song.getArtist();
    }

    public Song toDomain() {
        return Song.builder()
            .id(String.valueOf(this.id))
            .name(this.name)
            .album(this.album)
            .artist(this.artist)
            .build();
    }
}
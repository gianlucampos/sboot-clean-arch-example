package br.com.gianlucampos.sbootcleanarchexample.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Song {

    private String id;
    private String name;
    private String album;
    private String artist;

}
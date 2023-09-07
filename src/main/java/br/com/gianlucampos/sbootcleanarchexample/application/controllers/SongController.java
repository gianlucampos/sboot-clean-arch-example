package br.com.gianlucampos.sbootcleanarchexample.application.controllers;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/songs")
public class SongController {

    private final SongService songService;

    @GetMapping("{id}")
    public ResponseEntity<SongDTO> getSong(@PathVariable String id) {
        var song = songService.retrieveSong(id);
        return ResponseEntity.ok(song);
    }

    @PostMapping
    public ResponseEntity<SongDTO> addSong(@RequestBody SongDTO dto) {
        songService.saveSong(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
        return ResponseEntity.ok().build();
    }

}

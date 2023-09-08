package br.com.gianlucampos.sbootcleanarchexample.application.controllers;

import br.com.gianlucampos.sbootcleanarchexample.application.dtos.SongDTO;
import br.com.gianlucampos.sbootcleanarchexample.domain.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/songs/{id}")
    public ResponseEntity<SongDTO> getSong(@PathVariable String id) {
        var song = clientService.retrieveSong(id);
        return ResponseEntity.ok(song);
    }
}

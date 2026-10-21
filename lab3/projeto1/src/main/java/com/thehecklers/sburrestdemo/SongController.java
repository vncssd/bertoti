package com.thehecklers.sburrestdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:8080", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/songs")
class SongController {

    private final SongDAO songDAO = new SongDAO();

    @GetMapping
    Iterable<Song> getSongs() {
        return songDAO.buscarTodos();
    }

    @GetMapping("/{id}")
    Optional<Song> getSongById(@PathVariable UUID id) {
        Song song = songDAO.buscarPorId(id);
        return Optional.ofNullable(song);
    }

    @PostMapping
    Song postSong(@RequestBody Song song) {
        if (song.getId() == null) {
            song.setId(UUID.randomUUID());
        }
        return songDAO.salvar(song);
    }

    @PutMapping("/{id}")
    ResponseEntity<Song> putSong(@PathVariable UUID id,
                                 @RequestBody Song song) {

        Song songExistente = songDAO.buscarPorId(id);

        if (songExistente == null) {
            song.setId(id);
            Song novaSong = songDAO.salvar(song);
            return new ResponseEntity<>(novaSong, HttpStatus.CREATED);
        } else {
            song.setId(id);
            Song songAtualizada = songDAO.atualizar(song);
            return new ResponseEntity<>(songAtualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    void deleteSong(@PathVariable UUID id) {
        Song song = new Song();
        song.setId(id);
        songDAO.apagar(song);
    }
}

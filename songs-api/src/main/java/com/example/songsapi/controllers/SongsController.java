package com.example.songsapi.controllers;

import com.example.songsapi.models.Song;
import com.example.songsapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongsController {

    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public Iterable<Song> findAllSongs(){
        return songRepository.findAll();
    }

    @GetMapping("/songs/{songId}")
    public Song findById(@PathVariable Long songId){
        return songRepository.findOne(songId);
    }

    @PostMapping("/songs")
    public Song createSong(@PathVariable Song song){
        return songRepository.save(song);
    }

    @DeleteMapping("/songs/{songId}")
    public HttpStatus deteSong(@PathVariable Long songId){
        songRepository.delete(songId);
        return HttpStatus.OK;
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable Long songId, @RequestBody Song songRequest){
        Song songFromDb = songRepository.findOne(songId);
        songFromDb.setTitle(songRequest.getTitle());
        songFromDb.setLength(songRequest.getLength());
        songFromDb.setArtist(songRequest.getArtist());
        return songRepository.save(songFromDb);

    }
}

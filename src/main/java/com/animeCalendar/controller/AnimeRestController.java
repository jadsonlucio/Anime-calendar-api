package com.animeCalendar.controller;

import com.animeCalendar.database.AnimeDatabase;
import com.animeCalendar.database.GenreDatabase;
import com.animeCalendar.models.Anime;
import com.animeCalendar.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AnimeRestController {

    @Autowired
    private AnimeDatabase animeDatabase;

    @Autowired
    private GenreDatabase genreDatabase;

    @GetMapping("/anime/all")
    public List<Anime> getAllAnimes(){
        return animeDatabase.findAll();
    }

    @GetMapping("/anime/{id}")
    @ResponseBody
    public Anime getAnime(@PathVariable int id){
        Anime anime = animeDatabase.getOne(id);
        System.out.println(anime.getName());
        return animeDatabase.getOne(id);
    }

    @PostMapping("/anime/save")
    public ResponseEntity<?> saveAnime(@RequestBody Anime anime){

        List<Genre> genres = new ArrayList<Genre>();
        for(String genreName : anime.getGenresNames().split(",")){
            Optional<Genre> genreFound = genreDatabase.findById(genreName);
            if(!genreFound.isPresent()){
                return ResponseEntity.notFound().build();
            }else {
                genres.add(genreFound.get());
            }
        }

        anime.setGenres(genres);


        Anime savedAnime = animeDatabase.save(anime);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAnime.getId()).toUri();

        return ResponseEntity.created(uri).body("Anime " + savedAnime.getName() + " salvo com id:" + savedAnime.getId());
    }

}

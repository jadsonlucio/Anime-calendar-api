package com.animeCalendar.controller;

import com.animeCalendar.database.AnimeDatabase;
import com.animeCalendar.database.EpisodeDatabase;
import com.animeCalendar.database.GenreDatabase;
import com.animeCalendar.models.Anime;
import com.animeCalendar.models.Episode;
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

    @Autowired
    private EpisodeDatabase episodeDatabase;

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
        setAnimeGenres(anime);
        setAnimeEpisodes(anime);

        Anime savedAnime = animeDatabase.save(anime);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAnime.getId()).toUri();

        return ResponseEntity.created(uri).body("Anime " + savedAnime.getName() + " saved with id of:" + savedAnime.getId());
    }

    @PostMapping("/anime/{id}/episode/save")
    public ResponseEntity<?> saveEpisode(@RequestBody Episode episode, @PathVariable int id){
        Anime anime = animeDatabase.getOne(id);
        episode.setAnime(anime);
        Episode savedEpisode = episodeDatabase.save(episode);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEpisode.getId()).toUri();

        return ResponseEntity.created(uri).body("Episode of anime" + anime.getName() + " saved with id of:" + savedEpisode.getId());
    }


    /** Data manipulation methods **/
    private void setAnimeGenres(Anime anime){
        ArrayList<Integer> gendersIds = anime.getGendersIds();
        anime.setGenres(null);
        for(Integer genreId: gendersIds){
            Genre genre = genreDatabase.getOne(genreId);
            genre.addAnime(anime);

        }
    }

    private void setAnimeEpisodes(Anime anime){
        for(Episode episode : anime.getEpisodes()){
            episode.setAnime(anime);
        }
    }

}

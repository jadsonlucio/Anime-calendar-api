package com.animeCalendar.controller;

import com.animeCalendar.database.AnimeWatchDatabase;
import com.animeCalendar.database.EpisodeDatabase;
import com.animeCalendar.database.EpisodeWatchDatabase;
import com.animeCalendar.database.UserDatabase;
import com.animeCalendar.models.*;
import com.animeCalendar.models.compositeKeys.AnimeWatchKey;
import com.animeCalendar.models.compositeKeys.EpisodeWatchKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {
    @Autowired
    private UserDatabase userDatabase;

    @Autowired
    private EpisodeDatabase episodeDatabase;

    @Autowired
    private EpisodeWatchDatabase episodeWatchDatabase;

    @Autowired
    private AnimeWatchDatabase animeWatchDatabase;

    @GetMapping("/user/all")
    public List<User> getAllUsers(){
        return userDatabase.findAll();
    }

    @GetMapping("/user/{user_id}")
    public Optional<User> getUserById(@PathVariable int user_id){
        return userDatabase.findById(user_id);
    }

    @PostMapping("/user/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User savedUser =  userDatabase.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(uri).body("User saved with id of:" + savedUser.getId());
    }

    @PostMapping("/user/{user_id}/watch/{episode_id}")
    public ResponseEntity<?> saveWatchedEpisode(@RequestBody EpisodeWatch episodeWatch,@PathVariable int user_id,@PathVariable int episode_id){
        User user = userDatabase.getOne(user_id);
        Episode episode = episodeDatabase.getOne(episode_id);
        Anime anime = episode.anime();
        AnimeWatch animeWatch;

        episode.watch(episodeWatch);
        episodeDatabase.save(episode);

        Optional<AnimeWatch> optionalAnimeWatch = animeWatchDatabase.findById(new AnimeWatchKey(anime, user));

        if(optionalAnimeWatch.isPresent()){
            animeWatch = optionalAnimeWatch.get();
            episodeWatch.setEpisodeWatchKey(new EpisodeWatchKey(episode, animeWatch));
            animeWatch.getEpisodesWatched().add(episodeWatch);

            animeWatchDatabase.save(animeWatch);


        }else{
            ArrayList<EpisodeWatch> episodeWatches = new ArrayList<>();

            animeWatch = new AnimeWatch();
            animeWatch.setAnimeWatchKey(new AnimeWatchKey(anime, user));
            episodeWatch.setEpisodeWatchKey(new EpisodeWatchKey(episode, animeWatch));
            episodeWatches.add(episodeWatch);
            animeWatch.setEpisodesWatched(episodeWatches);

            animeWatchDatabase.save(animeWatch);
        }


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(12).toUri();

        return ResponseEntity.created(uri).body("Episode " +episode.getTitle()+" watched by user with id:" + user.getId());
    }

}

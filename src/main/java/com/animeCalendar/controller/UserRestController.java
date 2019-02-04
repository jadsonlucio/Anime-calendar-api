package com.animeCalendar.controller;

import com.animeCalendar.database.EpisodeDatabase;
import com.animeCalendar.database.EpisodeWatchDatabase;
import com.animeCalendar.database.UserDatabase;
import com.animeCalendar.models.AnimeWatch;
import com.animeCalendar.models.Episode;
import com.animeCalendar.models.EpisodeWatch;
import com.animeCalendar.models.User;
import com.animeCalendar.models.compositeKeys.AnimeWatchKey;
import com.animeCalendar.models.compositeKeys.EpisodeWatchKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserDatabase userDatabase;

    @Autowired
    private EpisodeDatabase episodeDatabase;

    @Autowired
    private EpisodeWatchDatabase episodeWatchDatabase;

    @GetMapping("/user/all")
    public List<User> getAllUsers(){
        return userDatabase.findAll();
    }

    @PostMapping("/user/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        System.out.println(user.getAnimesWatched().get(0).getAnimeWatchKey());
        User savedUser =  userDatabase.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(uri).body("User saved with id of:" + savedUser.getId());
    }

    @PostMapping("/user/{user_id}/watch/{episode_id}")
    public ResponseEntity<?> saveWatchedEpisode(@RequestBody EpisodeWatch episodeWatch,@PathVariable int user_id,@PathVariable int episode_id){
        System.out.println(episodeWatch.getEpisodeWatchKey());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(12).toUri();

        return ResponseEntity.created(uri).body("Episode " +11+"watched by user with id:" + 12);
    }

}

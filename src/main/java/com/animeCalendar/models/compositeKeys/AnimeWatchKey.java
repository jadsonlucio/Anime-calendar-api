package com.animeCalendar.models.compositeKeys;

import com.animeCalendar.models.Anime;
import com.animeCalendar.models.User;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class AnimeWatchKey implements Serializable {

    @OneToOne
    private Anime anime;

    @OneToOne
    @JoinColumn
    private User user;

    public AnimeWatchKey() {}

    public AnimeWatchKey(Anime anime, User user) {
        this.anime = anime;
        this.user = user;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

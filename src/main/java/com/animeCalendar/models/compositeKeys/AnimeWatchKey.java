package com.animeCalendar.models.compositeKeys;

import com.animeCalendar.models.Anime;
import com.animeCalendar.models.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class AnimeWatchKey implements Serializable {

    @OneToOne
    private Anime anime;

    @OneToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

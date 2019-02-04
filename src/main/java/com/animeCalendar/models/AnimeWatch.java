package com.animeCalendar.models;

import com.animeCalendar.models.compositeKeys.AnimeWatchKey;

import javax.persistence.*;
import java.util.List;

@Entity
public class AnimeWatch{
    @EmbeddedId
    private AnimeWatchKey animeWatchKey;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EpisodeWatch> episodesWatched;

    public AnimeWatch() {}

    public AnimeWatch(AnimeWatchKey animeWatchKey, List<EpisodeWatch> episodesWatched) {
        this.animeWatchKey = animeWatchKey;
        this.episodesWatched = episodesWatched;
    }

    public AnimeWatchKey getAnimeWatchKey() {
        return animeWatchKey;
    }

    public void setAnimeWatchKey(AnimeWatchKey animeWatchKey) {
        this.animeWatchKey = animeWatchKey;
    }

    public List<EpisodeWatch> getEpisodesWatched() {
        return episodesWatched;
    }

    public void setEpisodesWatched(List<EpisodeWatch> episodesWatched) {
        this.episodesWatched = episodesWatched;
    }


}

package com.animeCalendar.models.compositeKeys;

import com.animeCalendar.models.AnimeWatch;
import com.animeCalendar.models.Episode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class EpisodeWatchKey implements Serializable {

    @OneToOne
    private Episode episode;

    @OneToOne
    private AnimeWatch animeWatch;

    public EpisodeWatchKey() {}

    public EpisodeWatchKey(Episode episode, AnimeWatch animeWatch) {
        this.episode = episode;
        this.animeWatch = animeWatch;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public AnimeWatch getAnimeWatch() {
        return animeWatch;
    }

    public void setAnimeWatch(AnimeWatch animeWatch) {
        this.animeWatch = animeWatch;
    }
}

package com.animeCalendar.models;

import com.animeCalendar.models.compositeKeys.EpisodeWatchKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class EpisodeWatch {

    @EmbeddedId
    private EpisodeWatchKey episodeWatchKey;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date watchDate;

    private String comment;
    private int punctuation;
    private String watchSource;

    public EpisodeWatch() {}

    public EpisodeWatch(String comment, int punctuation, String watchSource) {
        this.comment = comment;
        this.punctuation = punctuation;
        this.watchSource = watchSource;
    }

    public EpisodeWatchKey getEpisodeWatchKey() {
        return episodeWatchKey;
    }

    public void setEpisodeWatchKey(EpisodeWatchKey episodeWatchKey) {
        this.episodeWatchKey = episodeWatchKey;
    }

    public Date getWatchDate() {
        return watchDate;
    }

    public void setWatchDate(Date watchDate) {
        this.watchDate = watchDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getpunctuation() {
        return punctuation;
    }

    public void setpunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    public String getwatchSource() {
        return watchSource;
    }

    public void setwatchSource(String watchSource) {
        this.watchSource = watchSource;
    }
}

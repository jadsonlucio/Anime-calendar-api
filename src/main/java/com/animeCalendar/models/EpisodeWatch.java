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
    private int nota;
    private String fonte;

    public EpisodeWatch() {}

    public EpisodeWatch(String comment, int nota, String fonte) {
        this.comment = comment;
        this.nota = nota;
        this.fonte = fonte;
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
}

package com.animeCalendar.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Episode {
    @OneToOne
    @JsonIgnoreProperties("episodes")
    private Anime anime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private long releaseDate;
    private int durationMilliseconds;
    private int numberViews;
    private int likes;
    private int deslikes;
    private String miniatureImageUrl;

    public Episode(){ }

    public Episode(String title, long releaseDate, int durationMilliseconds, int numberViews, int likes, int deslikes, String miniatureImageUrl) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.durationMilliseconds = durationMilliseconds;
        this.numberViews = numberViews;
        this.likes = likes;
        this.deslikes = deslikes;
        this.miniatureImageUrl = miniatureImageUrl;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationMilliseconds() {
        return durationMilliseconds;
    }

    public void setDurationMilliseconds(int durationMilliseconds) {
        this.durationMilliseconds = durationMilliseconds;
    }

    public int getNumberViews() {
        return numberViews;
    }

    public void setNumberViews(int numberViews) {
        this.numberViews = numberViews;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDeslikes() {
        return deslikes;
    }

    public void setDeslikes(int deslikes) {
        this.deslikes = deslikes;
    }

    public String getMiniatureImageUrl() {
        return miniatureImageUrl;
    }

    public void setMiniatureImageUrl(String miniatureImageUrl) {
        this.miniatureImageUrl = miniatureImageUrl;
    }

    public void setAnime(Anime anime){ this.anime = anime; }

    public Anime anime(){
        return this.anime;
    }

    public void watch(EpisodeWatch episodeWatch){
        this.numberViews++;
    }
}

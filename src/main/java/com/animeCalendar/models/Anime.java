package com.animeCalendar.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Anime {

    @ManyToMany(mappedBy = "animes", cascade = CascadeType.ALL)
    private List<Genre> genres;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL)
    private List<Episode> episodes;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mainName;
    @Column(unique = true)
    private String name;
    private int numberEpisodes;
    private Date releaseDate;
    private Date endingDate;
    private String source;
    private String status;
    private String studio;
    private int season;

    public Anime(){}

    public Anime(String mainName, String name, int numberEpisodes, Date releaseDate, Date endingDate, String source, String status, String studio, int season) {
        this.genres = new ArrayList<Genre>();
        this.mainName = mainName;
        this.name = name;
        this.numberEpisodes = numberEpisodes;
        this.releaseDate = releaseDate;
        this.endingDate = endingDate;
        this.source = source;
        this.status = status;
        this.studio = studio;
        this.season = season;

    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberEpisodes() {
        return numberEpisodes;
    }

    public void setNumberEpisodes(int numberEpisodes) {
        this.numberEpisodes = numberEpisodes;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setEpisodes(List<Episode> episodes){ this.episodes = episodes; }

    public List<Episode> getEpisodes(){ return this.episodes; }

    public void addGenre(Genre genre){
        if(this.getGenres() == null){
            this.genres = new ArrayList<>();
        }

        this.getGenres().add(genre);
    }

    public ArrayList<Integer> getGendersIds(){
        ArrayList<Integer> gendersIds = new ArrayList<>();
        for(int cont=0;cont<this.getGenres().size();cont++){
            gendersIds.add(this.genres.get(cont).getId());
        }

        return gendersIds;
    }
}

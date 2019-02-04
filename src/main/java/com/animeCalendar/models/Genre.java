package com.animeCalendar.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {
    @JsonBackReference
    @ManyToMany
    @JoinTable
    private List<Anime> animes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String description;

    public Genre(){ }

    public Genre(String name, String description) {
        this.animes = new ArrayList<Anime>();
        this.name = name;
        this.description = description;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void addAnime(Anime anime){
        if(this.getAnimes() == null){
            this.animes = new ArrayList<>();
        }

        this.getAnimes().add(anime);
        anime.addGenre(this);
    }
}

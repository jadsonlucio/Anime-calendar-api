package com.animeCalendar.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {
    @ManyToMany
    @JoinTable
    private List<Anime> animes;

    @Id
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
}

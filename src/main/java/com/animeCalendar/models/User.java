package com.animeCalendar.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "animeWatchKey.user",cascade = CascadeType.ALL)
    private List<AnimeWatch> animesWatched;

    private String name;
    private String email;
    private int age;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date createdDate;
    private String gender;

    public User(){}

    public User(String name, String email, int age, String gender){
        this.setName(name);
        this.setEmail(email);
        this.setAge(age);
        this.setGender(gender);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreatedDate(){ return this.createdDate; }

    private void setCreatedDate(Date createdDate){ this.createdDate = createdDate; }

    public List<AnimeWatch> getAnimesWatched() {
        return animesWatched;
    }

    public void setAnimesWatched(List<AnimeWatch> animesWatched) {
        this.animesWatched = animesWatched;
    }
}

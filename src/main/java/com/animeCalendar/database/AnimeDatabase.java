package com.animeCalendar.database;

import com.animeCalendar.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeDatabase extends JpaRepository<Anime, Integer> {
}

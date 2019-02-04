package com.animeCalendar.database;

import com.animeCalendar.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDatabase extends JpaRepository<Genre, Integer> {
}

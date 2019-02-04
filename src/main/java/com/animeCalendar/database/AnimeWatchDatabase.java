package com.animeCalendar.database;

import com.animeCalendar.models.AnimeWatch;
import com.animeCalendar.models.compositeKeys.AnimeWatchKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeWatchDatabase extends JpaRepository<AnimeWatch, AnimeWatchKey> {
}

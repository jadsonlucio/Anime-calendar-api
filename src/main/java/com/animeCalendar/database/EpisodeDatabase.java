package com.animeCalendar.database;

import com.animeCalendar.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeDatabase extends JpaRepository<Episode, Integer> {
}

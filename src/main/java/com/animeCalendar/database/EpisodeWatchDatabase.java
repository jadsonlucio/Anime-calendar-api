package com.animeCalendar.database;

import com.animeCalendar.models.EpisodeWatch;
import com.animeCalendar.models.compositeKeys.EpisodeWatchKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeWatchDatabase extends JpaRepository<EpisodeWatch, EpisodeWatchKey> {
}

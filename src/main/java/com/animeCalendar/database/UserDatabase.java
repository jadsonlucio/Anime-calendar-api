package com.animeCalendar.database;

import com.animeCalendar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDatabase extends JpaRepository<User, Integer> {

}

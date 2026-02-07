package com.ggx.carschool.repositories;

import com.ggx.carschool.entities.Lesson;
import com.ggx.carschool.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("SELECT l FROM Lesson l WHERE l.instructor = :instructor AND l.startTime > :start AND l.startTime < :end")
    List<Lesson> findConflicts(
        @Param("instructor") User instructor,
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );
}

package com.deep.movie.repository;

import com.deep.movie.entity.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    List<Auditorium> findByIdIn(List<Long> auditoriumIdList);
}

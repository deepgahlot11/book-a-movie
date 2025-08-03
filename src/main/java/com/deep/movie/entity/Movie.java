package com.deep.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_name", nullable = false, length = 100)
    private String movieName;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "active")
    private Boolean active;

    @Version
    private Long version;
}

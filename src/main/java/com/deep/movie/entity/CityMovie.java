package com.deep.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "city_movie", uniqueConstraints = @UniqueConstraint(name = "uk_city_movie", columnNames = {"city_id", "movie_id"}))
@Data
public class CityMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false, foreignKey = @ForeignKey(name = "fk_city_movie_city"))
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false, foreignKey = @ForeignKey(name = "fk_movie_city_movie"))
    private Movie movie;
}

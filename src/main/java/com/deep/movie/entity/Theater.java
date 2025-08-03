package com.deep.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theater")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theater_name", nullable = false, length = 100)
    private String theaterName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false, foreignKey = @ForeignKey(name = "fk_theater_city"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "active", nullable = false)
    private Boolean active;

}

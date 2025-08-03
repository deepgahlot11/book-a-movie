package com.deep.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "auditorium")
@Data
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", nullable = false, foreignKey = @ForeignKey(name = "fk_audi_theater_audi"))
    private Theater theater;

    @Column(name = "audi_name", nullable = false, length = 20)
    private String audiName;

    @Column(name = "audi_rows", nullable = false)
    private Integer audiRows;

    @Column(name = "audi_columns", nullable = false)
    private Integer audiColumns;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Version
    private Long version;
}

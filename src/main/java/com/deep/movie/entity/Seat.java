package com.deep.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "seat", uniqueConstraints = @UniqueConstraint(name = "uk_audi_seats", columnNames = {"auditorium_id", "row_label", "col_number"}))
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id", nullable = false, foreignKey = @ForeignKey(name = "fk_seat_audi_seat"))
    private Auditorium auditorium;

    @Column(name = "row_label", nullable = false)
    private String rowLabel;

    @Column(name = "col_number", nullable = false)
    private Integer colNumber;

    @Column(name = "active", nullable = false)
    private Boolean active;
}

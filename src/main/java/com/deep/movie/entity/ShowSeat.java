package com.deep.movie.entity;

import com.deep.movie.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "show_seat", uniqueConstraints = @UniqueConstraint(name = "uk_show_seat", columnNames = {"show_id", "seat_id"}))
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", foreignKey = @ForeignKey(name = "fk_show_seat_show"))
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", foreignKey = @ForeignKey(name = "fk_seat_show_seat"))
    private Seat seat;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;
}

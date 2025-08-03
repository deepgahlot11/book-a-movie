package com.deep.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "booking_seat", uniqueConstraints = @UniqueConstraint(name = "uk_booking_showseat", columnNames = {"booking_id","show_seat_id"}))
@Data
public class BookingSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false, foreignKey = @ForeignKey(name = "fk_booking_showseat_booking"))
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_seat_id", nullable = false, foreignKey = @ForeignKey(name = "fk_showseat_booking_showseat"))
    private ShowSeat showSeat;
}

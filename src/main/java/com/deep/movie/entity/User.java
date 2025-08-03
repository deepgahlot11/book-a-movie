package com.deep.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_city_user"))
    private City city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "email", unique = true, length = 150)
    private String email;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "guest", nullable = false)
    private Boolean guest;
}

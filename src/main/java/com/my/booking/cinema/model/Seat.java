package com.my.booking.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "seats")
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "number")
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id")
    private Line line;

    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ticket ticket;

    @ManyToMany(mappedBy = "bookedSeatsList")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<MovieSession> movieSession;
}

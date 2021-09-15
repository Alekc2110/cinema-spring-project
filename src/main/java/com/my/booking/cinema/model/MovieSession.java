package com.my.booking.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "movie_sessions")
@Entity
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "show_time")
    private LocalDateTime showTime;

    @Column(name = "price")
    private int ticketPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "movieSession", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Ticket> ticketList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_sessions_booked_seats",
            joinColumns = { @JoinColumn(name = "movie_session_id") },
            inverseJoinColumns = { @JoinColumn(name = "seat_id") })
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Seat> bookedSeatsList;
}

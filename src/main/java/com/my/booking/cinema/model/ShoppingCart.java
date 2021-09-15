package com.my.booking.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "shopping_carts")
@Entity
public class ShoppingCart {
    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}

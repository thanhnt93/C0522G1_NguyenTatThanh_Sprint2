package com.codegym.be.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodCustomer {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_food", referencedColumnName = "id")
    private Food food;

    @Column(name = "is_delete")
    private boolean isDelete;
}

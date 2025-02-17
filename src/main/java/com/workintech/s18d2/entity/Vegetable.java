package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    // Boolean field to indicate if grown on a tree.
    private boolean isGrownOnTree;
}

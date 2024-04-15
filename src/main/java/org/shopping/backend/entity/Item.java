package org.shopping.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 100 , nullable = true)
    private String contents;

    @Column(length = 100 , nullable = false)
    private String title;

    @Column(length = 255 , nullable = true)
    private String image;
}

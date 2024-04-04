package org.shopping.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(length = 10, nullable = false)
    private String password;
}

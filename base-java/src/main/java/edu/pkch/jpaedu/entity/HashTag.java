package edu.pkch.jpaedu.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String value;

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}

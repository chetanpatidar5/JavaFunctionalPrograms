package com.spring.chetan.tracker.entity;

import jakarta.persistence.*;

@Table(name="release")
@Entity
public class Releases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA will use sequence from PgSQL
    private Long id;

    @Column(name = "date", nullable = false, length = 10)
    private String date;

    @Column(nullable = false, length = 2000)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

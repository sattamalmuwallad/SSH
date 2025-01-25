package com.moviewatchlist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String Title;
    private String director;
    private int releaseYear;

    public int getReleaseYear() {
        return releaseYear;
    }

    public Long getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return Title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

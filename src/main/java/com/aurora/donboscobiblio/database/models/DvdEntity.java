package com.aurora.donboscobiblio.database.models;

public class DvdEntity extends MaterialEntity{
    private String director;
    private String genre;
    private String releaseYear;
    private  Integer duration;

    public DvdEntity(Integer id, String title, String type, String director, String genre, String releaseYear, Integer duration) {
        super(id, title, type);
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}

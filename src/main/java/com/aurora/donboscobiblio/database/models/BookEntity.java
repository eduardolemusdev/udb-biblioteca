package com.aurora.donboscobiblio.database.models;

public class BookEntity extends MaterialEntity{
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String publisher;
    private Integer pages;

    public BookEntity() {}
    public BookEntity(Integer id, String title, String type, String author, String isbn, Integer publicationYear, String publisher, Integer pages) {
        super(id, title, type);
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.pages = pages;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return super.getTitle()+" - "+author+" - "+isbn+" - "+publicationYear+" - "+publisher;
    }
}

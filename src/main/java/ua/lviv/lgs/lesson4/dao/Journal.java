package ua.lviv.lgs.lesson4.dao;

import java.util.Objects;

public class Journal {

    private String name;
    private String publication;
    private Integer year;
    private Integer month;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Journal() {
    }


    public Journal(String name, String publication, Integer year, Integer month, Integer price) {
        this.name = name;
        this.publication = publication;
        this.year = year;
        this.month = month;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return year == journal.year &&
                month == journal.month &&
                Objects.equals(name, journal.name) &&
                Objects.equals(publication, journal.publication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, publication, year, month);
    }
}

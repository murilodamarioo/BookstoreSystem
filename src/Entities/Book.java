package Entities;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Book {
    private final String id;
    private String title;
    private final Author author;
    private boolean available;
    private final LocalDate registerDate;
    private LocalDate updateDate;

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Book(String title, Author author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.available = true;
        this.registerDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updateDate = LocalDate.now();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book {" +
                "\n Id = " + id +
                ",\n Title = " + title +
                ",\n Available = " + (available ? "Yes" : "No") +
                ",\n Register date = " + registerDate.format(formatter) +
                ",\n Update date = " + updateDate.format(formatter) +
                ",\n " + author +
                "\n}";
    }
}

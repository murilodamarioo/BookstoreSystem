package Entities;

import java.util.Date;
import java.util.UUID;

public class Book {
    private final String id;
    private String title;
    private final Author author;
    private boolean available;
    private final Date registerDate;
    private Date updateDate;

    public Book(String title, Author author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.available = true;
        this.registerDate = new Date();
        this.updateDate = new Date();
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updateDate = new Date();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "\nid = " + id +
                ",\n Título = " + title +
                ",\n Autor = " + author +
                ",\n Disponível = " + (available ? "Sim" : "Não") +
                ",\n Data cadastro = " + registerDate +
                ",\n Data Atualização = " + updateDate +
                "\n}";
    }
}

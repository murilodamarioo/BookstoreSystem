package Entities;

import java.util.ArrayList;
import java.util.List;

public class Libary {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Libary(List<Book> books, List<Author> authors, List<Loan> loans) {
        this.books = books;
        this.authors = authors;
        this.loans = loans;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Loan> getLoans() {
        return loans;
    }
}

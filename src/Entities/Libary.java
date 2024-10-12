package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Libary {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public Book searchBookById(String id) {
        for (Book book : books) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        return null;
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                return book;
            }
        }
        return null;
    }

    public void loanBook(Book book, String username) {
        if (book.isAvailable()) {
            Loan loan = new Loan(book, username);
            loans.add(loan);
            book.setAvailable(false);
        } else {
            System.out.println("This book is not available.");
        }
    }

    public void returnBook(String loanId) {
        for (Loan loan : loans) {
            if (Objects.equals(loan.getId(), loanId) && loan.isActive()) {
                loan.returnBook();
                break;
            }
        }
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

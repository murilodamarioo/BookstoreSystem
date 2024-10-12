package Entities;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private String id;
    private Book book;
    private String username;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean active;

    public Loan(Book book, String username) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.username = username;
        this.loanDate = LocalDate.now();
        this.returnDate = LocalDate.now().plusDays(5);
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getUserName() {
        return username;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return active;
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
        this.active = false;
        this.book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Loan {" +
                "\n Id = " + id +
                "\n " + book +
                "\n User = " + username +
                "\n Return date = " + returnDate +
                "\n Active = " + active +
                "\n}";
    }
}

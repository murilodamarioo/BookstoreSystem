package Entities;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private String id;
    private Book book;
    private String userName;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean active;

    public Loan(Book book, String userName) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.userName = userName;
        this.loanDate = LocalDate.now();
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getUserName() {
        return userName;
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
        return "Empréstimo {" +
                "\n id = " + id +
                "\n Livro = " + book +
                "\n Usuário = " + userName +
                "\n Data devolução = " + returnDate +
                "\n Ativo = " + active +
                "\n}";
    }
}

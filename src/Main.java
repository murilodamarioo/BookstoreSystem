import Entities.Author;
import Entities.Book;
import Entities.Libary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libary libary = new Libary();

        Scanner scanner = new Scanner(System.in);

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Read books file to instance the first registers of authors and books
        try {
            Path booksContent = Paths.get("C:\\Users\\muril\\rocketseat\\Formacao-Java\\BookstoreSystem\\src\\Files\\books.txt");
            List<String> lines = Files.readAllLines(booksContent);

            for (String line : lines) {
                String[] columns = line.split(";");
                String bookTitle = columns[0];
                String authorName = columns[1];
                String birthDateStr = columns[2];

                LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);

                Author author = new Author(authorName, birthDate);
                Book book = new Book(bookTitle, author);

                libary.addBook(book);
            }
        } catch (IOException error) {
            throw new RuntimeException(error);
        }

        while (true) {
            System.out.println("============= BookStore =============");
            System.out.println("Would you like to see our books available? (y/n)");

            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                List<Book> availableBooks = libary.getAvailableBooks();

                System.out.println("==== Available Books ====");
                for (Book book : availableBooks) {
                    System.out.println(book.getId() + ": " + book.getTitle());
                }

                System.out.print("\nEnter the book Id: ");
                String bookId = scanner.nextLine();

                Book choosenBook = libary.searchBookById(bookId);

                if (choosenBook != null && choosenBook.isAvailable()) {
                    System.out.print("\nEnter your name: ");
                    String username = scanner.nextLine();

                    libary.loanBook(choosenBook, username);
                    System.out.println("The book " + choosenBook.getTitle() + " was borrowed to " + username + "\n");
                } else {
                    System.out.println("Book not found or not available for loan.\n");
                }
            } else if (answer.equals("n")) {
                System.out.println("Thank for your visit :)");
                break;
            } else {
                System.out.println("Invalid option, try again!");
            }
        }

        scanner.close();
    }
}
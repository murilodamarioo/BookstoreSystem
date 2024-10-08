import Entities.Author;
import Entities.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

                authors.add(author);
                books.add(new Book(bookTitle, author));
            }

        } catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
}
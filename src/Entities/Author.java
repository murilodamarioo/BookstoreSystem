package Entities;

import java.time.LocalDate;
import java.util.UUID;

public class Author {
    private final String id;
    private String name;
    private LocalDate birthDate;

    public Author(String name, LocalDate birthDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "\n id = " + id +
                ",\n nome = " + name +
                ",\n birthDate =" + birthDate +
                "\n}";
    }
}

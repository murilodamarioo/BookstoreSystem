package Entities;

import java.util.Date;
import java.util.UUID;

public class Author {
    private final String id;
    private String name;
    private String birthDate;

    public Author(String name, String birthDate) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
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

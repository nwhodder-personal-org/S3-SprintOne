package classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Author {
    private ArrayList<Book> booksWrittenList; // Use array list as we don't know size
    private String name;
    private LocalDate dateOfBirth;

    public ArrayList<Book> getBooksWrittenList() {
        return booksWrittenList;
    }

    public void setBooksWrittenList(ArrayList<Book> booksWrittenList) {
        this.booksWrittenList = booksWrittenList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public ArrayList<Book> addBook(Book book){
        this.booksWrittenList.add(book);
        return this.booksWrittenList;
    }
}

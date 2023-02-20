package classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patron {
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private ArrayList<Book> borrowedBooks;

    public Patron() {
        this.borrowedBooks = new ArrayList<Book>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBorrowedBooks() {
        System.out.printf("List of books borrowed by %s:%n", this.getName());
        borrowedBooks.forEach((x) -> System.out.println("-" + x.getTitle()));
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public ArrayList<Book> addBook(Book book){
        this.borrowedBooks.add(book);
        return this.borrowedBooks;
    }

    public ArrayList<Book> removeBook(Book book){
        this.borrowedBooks.remove(book);
        return this.borrowedBooks;
    }
}

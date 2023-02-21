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

    public ArrayList<String> getBorrowedBooks() {
        ArrayList<String> bookArr = new ArrayList<String>();
        borrowedBooks.forEach((x) -> bookArr.add(x.getTitle()));
        return bookArr;
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

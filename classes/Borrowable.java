package classes;

public interface Borrowable {

    Book borrowBook(Book book, Patron patron);
//  Method to be used in Library and Book classes for loaning out books to patrons

    Book returnBook(Book book, Patron patron);
//  Method to be used in Library and Book classes for return books from patrons
}

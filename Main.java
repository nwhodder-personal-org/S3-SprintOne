import classes.Author;
import classes.Book;
import classes.Library;
import classes.Patron;

public class Main {
    public static void main(String[] args) {
        // Tests

        // Create author Mark Twain and two of his books
        Author markTwain = new Author();
        markTwain.setName("Mark Twain");
        Book huckFinn = new Book("Huck Finn", markTwain, "EXAMPLEISBN001", "American Publishing Co.", 4);
        Book tomSawyer = new Book("Tom Sawyer", markTwain, "EXAMPLEISBN002", "American Publishing Co.", 2);
        markTwain.addBook(huckFinn);
        markTwain.addBook(tomSawyer);

        // Create Ray Bradbury and his book
        Author rayBradbury = new Author();
        rayBradbury.setName("Ray Bradbury");
        Book fahrenheit451 = new Book("Fahrenheit 451", rayBradbury, "EXAMPLEISBN003", "Ballantine Books", 1);
        rayBradbury.addBook(fahrenheit451);

        // Create me as a Patron
        Patron nick = new Patron();
        nick.setName("Nick");
        nick.setDateOfBirth(1999, 2, 23);
        nick.setAddress("21 YellowBrick Road");

        // Create Kennedy as a Patron
        Patron kennedy = new Patron();
        kennedy.setName("Kennedy");
        kennedy.setDateOfBirth(1782, 3, 23);
        kennedy.setAddress("43 MadeUp Avenue");

        // Create Library and add books/test methods
        Library library = new Library();
        library.addBook(huckFinn);
        library.addAuthor(markTwain); // Should add Tom Sawyer and say Huck Finn is already in the system
        library.addAuthor(rayBradbury);
        library.addPatron(nick);
        library.addPatron(kennedy);
        library.borrowBook(fahrenheit451, nick);
        library.borrowBook(fahrenheit451, kennedy, 1); // Should log error that no more copies remain
        System.out.println("Nick's Borrowed Books:\n" + nick.getBorrowedBooks() + "\n");
        System.out.println("Kennedy's Borrowed Books:\n" + kennedy.getBorrowedBooks() + "\n");
        System.out.println("Patron List:\n" + library.getPatronList() + "\n");
        System.out.println("List of Books in Library:\n" + library.getBooksList() + "\n");
        System.out.println(library.returnBook(fahrenheit451, nick, 2)); // Set Fahrenheit451 back to 1 copy

        // Test searching books through various methods
        System.out.println(library.searchBooks("Mark Twain")); // return both Huck Finn and Tom Sawyer
        System.out.println(library.searchBooks("EXAMPLEISBN003")); // return Fahrenheit451
        System.out.println(library.searchBooks("Fahrenheit 451")); // return Fahrenheit451
        System.out.println(library.searchBooks("I don't exist")); // return empty ArrayList
    }
}
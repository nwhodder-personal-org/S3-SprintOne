package classes;

public class Book implements Borrowable {
    private String title;
    private Author author;  // Author references Author class
    private String ISBN;
    private String publisher;
    private int numberOfCopies;
    private Status status;

    //  Constructors
    public Book() { //  Empty Constructor
    }

    //  Complete Constructor
    public Book(String title, Author author, String ISBN, String publisher, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
    }

    //  Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //  toString Method for class
    @Override
    public String toString() {
        return String.format(
                "Book Title: %s%n" +
                "Author: %s%n" +
                "ISBN: %s%n" +
                "Publisher: %s%n" +
                "Copies: %d%n",
                title, author.getName(), ISBN, publisher, numberOfCopies);
    }

    //  Methods for borrowing and returning borrowed books

    public Book borrowBook(Book book, Patron patron) {
        return this.borrowBook(book, patron, 1);
    }

    @Override
    public Book borrowBook(Book book, Patron patron, int qty) {
        if (book.getNumberOfCopies() < qty){
            System.out.println("Error: Improper amount of books to loan out");
            book.setStatus(Status.CHECKED_OUT);
        } else {
            book.setNumberOfCopies(book.getNumberOfCopies() - qty);
            System.out.println(book.getTitle() + " x" + qty + " has been checked out by " + patron.getName());
            if (book.getNumberOfCopies() == 0){
                book.setStatus(Status.CHECKED_OUT);
            }else {
                book.setStatus(Status.AVAILABLE);
            }
            for (int i = 0; i < qty; i++) {
                patron.addBook(book);
            }
        }
        return book;
    }

    public Book returnBook(Book book, Patron patron) {
        return this.returnBook(book, patron, 1);
    }

    @Override
    public Book returnBook(Book book, Patron patron, int qty) {
        for (int i = 0; i < qty; i++) {
            if (patron.getBorrowedBooks().contains(book.getTitle())){
                patron.removeBook(book);
                book.setNumberOfCopies(book.getNumberOfCopies() + 1);
            } else {
                System.out.printf("Error: %s only has %d copy/copies of %s%n", patron.getName(),(qty - i), book.getTitle());
                break;
            }
        }

        return book;
    }
}

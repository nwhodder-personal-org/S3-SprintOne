package classes;

public class Book implements Borrowable {
    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private int numberOfCopies;
    private Status status;

    //  Constructors
    public Book() { //  Empty Constructor
    }

    //  Complete Constructor
    public Book(String title, String author, String ISBN, String publisher, int numberOfCopies) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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
                title, author, ISBN, publisher, numberOfCopies);
    }

    @Override
    public Book borrowBook(Book book, Patron patron) {
        if (!(book.getNumberOfCopies() > 0)){
            System.out.println("Error: Improper amount of books to loan out");
            book.setStatus(Status.CHECKED_OUT);
        } else {
            numberOfCopies--;
            System.out.println(book.getTitle() + " has been checked out by " + patron.getName());
            if (numberOfCopies == 0){
                book.setStatus(Status.CHECKED_OUT);
            }else {
                book.setStatus(Status.AVAILABLE);
            }
//            patron.addBook();
        }
        return book;
    }

    @Override
    public Book returnBook(Book book, Patron patron) {
        return book;
    }
}

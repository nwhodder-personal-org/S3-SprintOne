import classes.Book;
import classes.Patron;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Huck Finn", "Mark Twain", "EXAMPLEISBN001", "yesCorp", 1);
        System.out.println(book);
        Patron nick = new Patron();
        nick.setName("Nick");
        System.out.println(book.borrowBook(book, nick));
        System.out.println(book.borrowBook(book, nick));
    }
}
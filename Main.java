import classes.Author;
import classes.Book;
import classes.Patron;

public class Main {
    public static void main(String[] args) {
        Author markTwain = new Author();
        markTwain.setName("Mark Twain");
        Book book = new Book("Huck Finn", markTwain, "EXAMPLEISBN001", "yesCorp", 1);
        Book book2 = new Book("Smuch Smin", markTwain, "Examplbndaw", "yeye", 2);
        System.out.println(book);
        Patron nick = new Patron();
        nick.setName("Nick");
        System.out.println(book.borrowBook(book, nick));
        System.out.println(nick.getBorrowedBooks());
        System.out.println(book.returnBook(book, nick));
        System.out.println(nick.getBorrowedBooks());
//        nick.addBook(book2);
//        nick.getBorrowedBooks();
//        System.out.println(book.borrowBook(book, nick));
//        System.out.println(book.borrowBook(book, nick));
//        System.out.println(nick.removeBook(book));
    }
}
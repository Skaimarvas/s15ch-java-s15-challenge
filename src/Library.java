import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    //Encapsulation:
    private Map<Long, Book> availableBooks;
    private Map<Long, Book> lentBooks;
    public Library(Map<Long, Book> availableBooks) {
        this.availableBooks = availableBooks;
        this.lentBooks = new HashMap<>();
    }
    public void newBook(Book book){
        availableBooks.put(book.getBook_ID(), book);
    }
    public void lentBook(Book book, Reader reader){
        if(availableBooks.containsKey(book.getBook_ID())){

            reader.borrowedBooks(book);
            book.setStatus(Status.ON_LOAN);
        }
        if(lentBooks.containsKey(book.getBook_ID())){
            //burada getOwner methodunu kullanacağız
            System.out.println("This book was lent to: ");
        }
    }
    public void takeBackBook(Book book){
        if(lentBooks.containsKey(book.getBook_ID())){
            availableBooks.put(book.getBook_ID(), book);
        }
        System.out.println("This book has not been lent out from the library.");
    }
    public void showBook(){
        System.out.println("________________Available_Books_____________");
        if(!availableBooks.isEmpty()){
            for(Book book: availableBooks.values()){
                System.out.println("Book: " + book);
            }
        } else {
            System.out.println("There are no available books");
        }
        System.out.println("_______________Lent_Books______________");
        if(!lentBooks.isEmpty()){
            for (Book book: lentBooks.values()){
                System.out.println("Book: " + book);
            }
        } else {
            System.out.println("All books are available now");
        }

        System.out.println("_______________End_____________________");
    }
}

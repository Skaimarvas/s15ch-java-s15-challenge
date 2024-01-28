import java.util.*;


/**Notlar
 * Kitapları sadece librarian library aracılığıyla vermeli
 * Sadece üyelere vermeli;
 *
 *
 *
 */
public class Library {
    //Encapsulation:
    private Map<Long, Book> availableBooks;
    private Map<Long, Book> lentBooks;
    private Map<Long,MemberRecord> readers;

    public Library(Map<Long, Book> availableBooks) {
        this.availableBooks = availableBooks;
        this.lentBooks = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Map<Long, Book> getAvailableBooks() {
        return availableBooks;
    }
    public Map<Long, Book> getLentBooks() {
        return lentBooks;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(availableBooks, library.availableBooks) && Objects.equals(lentBooks, library.lentBooks);
    }
    @Override
    public int hashCode() {
        return Objects.hash(availableBooks, lentBooks);
    }
    @Override
    public String toString() {
        return "Library{" +
                "availableBooks=" + availableBooks +
                ", lentBooks=" + lentBooks +
                '}';
    }
}

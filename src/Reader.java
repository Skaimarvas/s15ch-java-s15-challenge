import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**Notlar:
 * Okuyucunun kitap ödünç alma limiti 5 olmalı
 * Sistemden bir kitap alındığında kitabı alan kullanıcıya bir fatura kesilmelidir.
 *
 */

public class Reader extends Person {

    private List<Book> purchasedBooks;
    private List<Book> borrowedBooks;

    public Reader(String name, String lastname) {
        super(name, lastname);
        this.purchasedBooks = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    public void purchasedBook(Book book){
        purchasedBooks.add(book);
    }

    public void borrowedBooks(Book book){
        borrowedBooks.add(book);
    }


    public void returnBook(Book book){
        if(borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            System.out.println( book +  "was returned to Library");
        }
        System.out.println( book + " was not borrowed from the Library");

    }

    public void showBook(){
        System.out.println("_________Purchased_Book______________");
        if(!purchasedBooks.isEmpty()){
            for (Book book: purchasedBooks){
                System.out.println("Book: " + book);
            }
        } else {
            System.out.println( getName() + " " + getLastname() + " hasn't purchased books");
        }

        System.out.println("_________Borrowed_Book_______________");
        if(!borrowedBooks.isEmpty()){
            for (Book book: borrowedBooks){
                System.out.println("Book: " + book);
            }
        } else {
            System.out.println( getName() + " " + getLastname() + " hasn't borrowed books");
        }
        System.out.println("_________End_________________________");
    }
    @Override
    public void whoYouAre() {
        System.out.println("Person is " + getClass().getSimpleName() + ": " + getName() + " " + getLastname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(purchasedBooks, reader.purchasedBooks) && Objects.equals(borrowedBooks, reader.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), purchasedBooks, borrowedBooks);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "purchasedBooks=" + purchasedBooks +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

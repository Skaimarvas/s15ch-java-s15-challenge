import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private int book_ID;
    private Author author;
    private String name;
    private double price;
    private Status status;

    private String edition;

    private String dateOfPurchase;

    public Book(int book_ID, Author author, String name, double price, Status status, String edition, String dateOfPurchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }
    public Book(){
        System.out.println("There is no book");
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public long getBook_ID() {
        return book_ID;
    }

    public String get_title(){
        return name;
    }
    public Author getAuthor(){
        return author;
    }
    public void changeOwner(){

    }

    public double getPrice() {
        return price;
    }

    public String getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Status getStatus() {
        return status;
    }
    //reader oluşturduğunda getOwner methodu yaz.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_ID == book.book_ID || author.getName().equals(book.author.getName()) && author.getLastname().equals(book.author.getLastname()) || name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_ID, author, name, price, status, edition, dateOfPurchase);
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return Integer.valueOf(o.book_ID).compareTo(book_ID);
    }
}

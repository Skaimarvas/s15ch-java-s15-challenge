import java.util.Objects;

public class Book {
    private long book_ID;
    private Author author;
    private String name;
    private double price;
    private Status status;

    private String edition;

    private String dateOfPurchase;

    public Book(long book_ID, Author author, String name, double price, Status status, String edition, String dateOfPurchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
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
        return book_ID == book.book_ID ;
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
}

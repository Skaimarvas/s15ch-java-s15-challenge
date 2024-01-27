import java.util.List;

public class Author extends Person{

    private List<Book> books;

    public Author(String name, String lastname) {
        super(name, lastname);

    }

    public void newBook(Book book){
        books.add(book);
    }

    public void showBook(List<Book> books){
        for(Book book: books){
            System.out.println("Book: " + book);
        }
    }
    @Override
    public void whoYouAre() {
        System.out.println("Person is: " + getClass().getSimpleName() + ": " + getName());
    }


}

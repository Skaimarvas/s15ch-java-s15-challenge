import java.util.List;

public class Author extends Person{

    private List<String> books;

    public Author(String name, String lastname, List<String> books) {
        super(name, lastname);
        this.books = books;
    }

    public void newBook(String book){
        books.add(book);
    }

    public void showBook(List<String> books){
        for(String book: books){
            System.out.println("Book: " + book);
        }
    }
    @Override
    public void whoYouAre() {
        System.out.println("Person is: " + getClass().getSimpleName() + ": " + getName());
    }


}

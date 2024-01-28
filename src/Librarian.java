public class Librarian extends Person{
    private String password;
    public Librarian(String name, String lastname, String password) {
        super(name, lastname);
        this.password = password;
    }
    public Book searchBook(int bookId, String bookname,String authorname, String authorlastname, Library library){
        for(Book book: library.getAvailableBooks().values()){
            if(book.getAuthor().getName().equals(authorname) && book.getAuthor().getLastname().equals(authorlastname) || book.getBook_ID() == bookId || book.getName().equals(bookname)){
                return book;
            }
        };
        return new Book();
    }
    @Override
    public String getLastname() {
        return super.getLastname();
    }
    @Override
    public String getName(){
        return super.getName();
    }
    @Override
    public void whoYouAre() {
        System.out.println("Person is " + getClass().getSimpleName() + ": " + getName() + " " + getLastname());
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

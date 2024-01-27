public class Main {
    public static void main(String[] args) {
        Author stephenKings = new Author("Stephen","King");
        Book theShining = new Book(1,stephenKings,"The Shining",20.4,Status.AVAILABLE,"13th edition","20-01-2005");
        stephenKings.newBook(theShining);
        System.out.println("____________Book________________");
        stephenKings.showBook();
        stephenKings.whoYouAre();
    }
}
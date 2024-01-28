public class Main {
    public static void main(String[] args) {
        //------------------------Author---------------------------------------
        Author jeanChristopheGrange = new Author("Jean Christophe", "Grange");
        Author stephenKings = new Author("Stephen","King");


        //------------------------Books--------------------------------------------------
        Book theShining = new Book(1,stephenKings,"The Shining",20.4,Status.NOT_IN_CATALOG,"13th edition","20-01-2005");
        Book theGreenMile = new Book(2,stephenKings,"The Green Mile",20.5,Status.NOT_IN_CATALOG,"14th edition","01-07-2000");



        stephenKings.newBook(theShining);
        stephenKings.newBook(theGreenMile);
        System.out.println("____________Book________________");
        stephenKings.showBook();
        stephenKings.whoYouAre();

        //Runtime Polymorphism
        Person kaimarvas = new Reader("Kaim", "Arvas");

        //ClassCasting
        ((Reader)kaimarvas).borrowedBooks(theGreenMile);
        ((Reader)kaimarvas).borrowedBooks(theShining);
        ((Reader)kaimarvas).purchasedBook(theShining);
        ((Reader)kaimarvas).showBook();
    }
}
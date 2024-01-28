import com.workintech.book.Book;
import com.workintech.book.Status;
import com.workintech.library.Librarian;
import com.workintech.person.Author;
import com.workintech.person.Person;
import com.workintech.person.Reader;

public class Main {
    public static void main(String[] args) {
        //------------------------Author----------------------------------------
        Author jeanChristopheGrange = new Author("Jean Christophe", "Grange");
        Author stephenKings = new Author("Stephen","King");

        //-----------------------Librarian--------------------------------------
        Librarian librarian1 = new Librarian("Volkan","Konak","asdf123456");
        Librarian librarian2 = new Librarian("Dilber","Ay", "123456asdf");

        //-----------------------Add-Member-by-Librarian------------------------



        //------------------------Books-----------------------------------------
        Book flightOfTheStorks = new Book(3,jeanChristopheGrange,"Flight of the Storks",23,Status.NOT_IN_CATALOG,"2nd edition", "31-10-2016");
        Book theShining = new Book(1,stephenKings,"The Shining",20.4, Status.NOT_IN_CATALOG,"13th edition","20-01-2005");
        Book theGreenMile = new Book(2,stephenKings,"The Green Mile",20.5,Status.NOT_IN_CATALOG,"14th edition","01-07-2000");


        //----------------------Add-New-Book-To-Author--------------------------
        jeanChristopheGrange.newBook(flightOfTheStorks);
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
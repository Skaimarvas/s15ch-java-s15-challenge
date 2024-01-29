import com.workintech.book.Book;
import com.workintech.book.Status;
import com.workintech.library.Librarian;
import com.workintech.library.Library;
import com.workintech.library.MemberRecord;
import com.workintech.library.MemberType;
import com.workintech.person.Author;
import com.workintech.person.Person;
import com.workintech.person.Reader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //------------------------Author----------------------------------------
        Author jeanChristopheGrange = new Author("Jean Christophe", "Grange");
        Author stephenKings = new Author("Stephen","King");

        //------------------------Books-----------------------------------------
        Book flightOfTheStorks = new Book(3,jeanChristopheGrange,"Flight of the Storks",23,Status.NOT_IN_CATALOG,"2nd edition", "31-10-2016");
        Book theShining = new Book(1,stephenKings,"The Shining",20.4, Status.NOT_IN_CATALOG,"13th edition","20-01-2005");
        Book theGreenMile = new Book(2,stephenKings,"The Gr Mile",20.5,Status.NOT_IN_CATALOG,"14th edition","01-07-2000");

        //-----------------------Librarian--------------------------------------
        Librarian librarian1 = new Librarian("Volkan","Konak","asdf123456", 1);
        Librarian librarian2 = new Librarian("Dilber","Ay", "123zorundamıyım",2);
        Librarian librarian3 = new Librarian("Mustafa", "Keser","beyazmendil123",3);

        //-----------------------Library----------------------------------------
        Map<Long, Book> librarybooks = new HashMap<>();
        flightOfTheStorks.setStatus(Status.AVAILABLE);
        theShining.setStatus(Status.AVAILABLE);
        theGreenMile.setStatus(Status.AVAILABLE);
        librarybooks.put(flightOfTheStorks.getBook_ID(),flightOfTheStorks);
        librarybooks.put(theShining.getBook_ID(),theShining);
        librarybooks.put(theGreenMile.getBook_ID(),theGreenMile);
        Library trinityCollegeLibrary = new Library(librarybooks,"Trinity College Library");
        trinityCollegeLibrary.showBook();


        //-----------------------Add-Librarian-by-Library-----------------------
        trinityCollegeLibrary.addLibrarian(librarian1);
        trinityCollegeLibrary.addLibrarian(librarian1);
        trinityCollegeLibrary.addLibrarian(librarian2);



        //-----------------------Add-Member-by-Librarian------------------------
        Person kaimarvas = new Reader("Kaim", "Arvas");
        MemberRecord member1 = new MemberRecord( ((Reader)kaimarvas),1,MemberType.USER, "11-01-2024","Istanbul","555-55-55" );
        librarian3.addMember(trinityCollegeLibrary,member1);
        librarian1.addMember(trinityCollegeLibrary,member1);

         /*
        //----------------------Book-Search------------------------------------
        System.out.println("_______________Searching_Book______________________");
        librarian1.searchBookbyAuthorLastName("kin", trinityCollegeLibrary);
        librarian2.searchBookbyAuthorName("jean", trinityCollegeLibrary);
        librarian2.searchBookbyBookName("gre", trinityCollegeLibrary);
        librarian1.searchBookbyID(2, trinityCollegeLibrary);

        System.out.println("_______________Searching_Book______________________");
        */

        //---------------------Update-Book-Data-----------------------------------

        Book newbook = new Book(2,stephenKings,"The Green Mile", 40,Status.AVAILABLE, "14th edition", "01-07-2005");
        librarian1.updatedBookInfo(newbook,trinityCollegeLibrary);

        //---------------------Issue-Book---------------------------------------
        Reader natalie = new Reader("Natalie", "Portman");
        MemberRecord member2 = new MemberRecord(natalie,2,MemberType.STUDENT,"12-02-2021","France","222-222-22-22");
        librarian1.addMember(trinityCollegeLibrary,member2);
        librarian1.issueBook(trinityCollegeLibrary,theGreenMile,member1);
        librarian2.issueBook(trinityCollegeLibrary,theGreenMile,member2);

        //----------------------Add-New-Book-To-Author--------------------------
        jeanChristopheGrange.newBook(flightOfTheStorks);
        stephenKings.newBook(theShining);
        stephenKings.newBook(theGreenMile);
        System.out.println("____________Book________________");
        stephenKings.showBook();
        stephenKings.whoYouAre();

        //Runtime Polymorphism
        Person johnDoe = new Reader("John", "Doe");
        /*
        //ClassCasting
        ((Reader)kaimarvas).borrowedBooks(theGreenMile);
        ((Reader)kaimarvas).borrowedBooks(theShining);
        ((Reader)kaimarvas).purchasedBook(theShining);
        ((Reader)kaimarvas).showBook();
        */

    }
}
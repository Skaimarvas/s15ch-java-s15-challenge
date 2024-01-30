import com.workintech.book.Book;
import com.workintech.book.Status;
import com.workintech.library.Librarian;
import com.workintech.library.Library;
import com.workintech.library.MemberRecord;
import com.workintech.library.MemberType;
import com.workintech.person.Author;
import com.workintech.person.Person;
import com.workintech.person.Reader;
import java.util.*;

/**
 * Tekrar tekrar oluşturmamak için Library ve Librarian objelerini main class içinde,
 * static olarak oluşturdum.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Librarian> librarianList = new ArrayList<>();
    private static Library trinityCollegeLibrary = new Library("Trinity College Library");
    private static Librarian librarian1 = new Librarian("Volkan","Konak","asd123", 1);
    private static Librarian librarian2 = new Librarian("Dilber","Ay", "123zor",2);
    private static Librarian librarian3 = new Librarian("Mustafa", "Keser","dil123",3);
    public static void main(String[] args) {
        //------------------------Author----------------------------------------
        Author jeanChristopheGrange = new Author("Jean Christophe", "Grange");
        Author stephenKings = new Author("Stephen","King");
        Author johnFowles = new Author("John", "Fowles");
        Author ursulaKLeGuin = new Author("Ursula Kroeber","Le Guin");
        Author jKRowling = new Author("Joanne", "Rowling");

        //------------------------Books-----------------------------------------
        Book flightOfTheStorks = new Book(3,jeanChristopheGrange,"Flight of the Storks",23,Status.NOT_IN_CATALOG,"2nd edition", "31-10-2016");
        Book theShining = new Book(1,stephenKings,"The Shining",20.4, Status.NOT_IN_CATALOG,"13th edition","20-01-2005");
        Book theGreenMile = new Book(2,stephenKings,"The Gr Mile",20.5,Status.NOT_IN_CATALOG,"14th edition","01-07-2000");
        Book theCollector = new Book(3,johnFowles,"The Collector", 25,Status.NOT_IN_CATALOG,"3rd edition", "15-12-1999");
        Book theMagus = new Book(4,johnFowles, "The Magus", 67,Status.NOT_IN_CATALOG,"11th edition", "01-11-1987");
        Book theFrenchLieutenantsWoman = new Book(5,johnFowles,"The French Lieutenant's Woman", 21,Status.NOT_IN_CATALOG,"4th edition", "12-07-1987");
        Book harryPotterThePS = new Book(6,jKRowling,"Harry Potter and The Philosopher Stone", 100,Status.NOT_IN_CATALOG,"2nd edition", "05-03-2008");
        Book talesFromEarthsea = new Book(7,ursulaKLeGuin,"Tales From Earthsea", 89,Status.NOT_IN_CATALOG,"6th edition","02-03-1998");
        //-----------------------Librarian--------------------------------------


        librarianList.add(librarian1);
        librarianList.add(librarian2);
        librarianList.add(librarian3);
        //----------------------Add-New-Book-To-Author--------------------------
        /**
         * newbook methodunda check var mı?
         */
        jeanChristopheGrange.addNewBook(flightOfTheStorks);
        stephenKings.addNewBook(theShining);
        stephenKings.addNewBook(theGreenMile);
        johnFowles.addNewBook(theCollector);
        johnFowles.addNewBook(theMagus);
        johnFowles.addNewBook(theMagus);
        johnFowles.addNewBook(theFrenchLieutenantsWoman);
        jKRowling.addNewBook(harryPotterThePS);
        ursulaKLeGuin.addNewBook(talesFromEarthsea);
        System.out.println("----------------Show-Book--------------------------");
        ursulaKLeGuin.showBook();
        johnFowles.showBook();
        jeanChristopheGrange.showBook();
        stephenKings.showBook();
        System.out.println("----------------Show-Book-End-------------------------");
        //-----------------------Library----------------------------------------

        trinityCollegeLibrary.newBook(flightOfTheStorks);
        trinityCollegeLibrary.newBook(theShining);
        trinityCollegeLibrary.newBook(theGreenMile);
        trinityCollegeLibrary.newBook(theCollector);
        trinityCollegeLibrary.newBook(theMagus);
        trinityCollegeLibrary.newBook(theFrenchLieutenantsWoman);
        trinityCollegeLibrary.newBook(harryPotterThePS);
        trinityCollegeLibrary.newBook(talesFromEarthsea);
        trinityCollegeLibrary.newBook(talesFromEarthsea);
        trinityCollegeLibrary.showBook();


        //-----------------------Add-Librarian-by-Library-----------------------
        trinityCollegeLibrary.addLibrarian(librarian1);
        trinityCollegeLibrary.addLibrarian(librarian1);
        trinityCollegeLibrary.addLibrarian(librarian2);


        //-----------------------Add-Member-by-Librarian------------------------
        Reader kaimarvas = new Reader("Kaim", "Arvas");
        MemberRecord member1 = new MemberRecord( kaimarvas,1,MemberType.USER, "11-01-2024","Istanbul","555-55-55" );
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


        //-------------------Take-Back-Book------------------------------------
        System.out.println("------------Take-Back-Book---------------------");
        librarian1.takeIssueBook(trinityCollegeLibrary,theGreenMile,member1);
        System.out.println("------------Take-Back-Book---------------------");

        //Runtime Polymorphism
        Person johnDoe = new Reader("John", "Doe");
        /*
        //ClassCasting
        ((Reader)kaimarvas).borrowedBooks(theGreenMile);
        ((Reader)kaimarvas).borrowedBooks(theShining);
        ((Reader)kaimarvas).purchasedBook(theShining);
        ((Reader)kaimarvas).showBook();
        */
        String enter ;
        long userId ;
        String password = null;
        String entry = null;
        Librarian loggedLibrarian = null;
        int option;
        System.out.println("*********LIBRARY-SYSTEM*********************************************************");
        System.out.println("---------WELCOME-" + trinityCollegeLibrary.getName() + "-SYSTEM-----------------");
        printIntro(); 
        do {
            
              userId = scanner.nextLong();
              scanner.nextLine();
              password = scanner.nextLine();
              loggedLibrarian = verifyLibrarianOnSystem(userId,password);
              if(loggedLibrarian != null){
                  System.out.println("Login successful! Welcome, " + loggedLibrarian.getName() + " " + loggedLibrarian.getLastname());
                  printMenu();
                  break;
                  
              } else {
                  System.out.println("Incorrect password. Please try again");
              }

        } while (password != null);
        System.out.println("*********LIBRARY-SYSTEM*********************************************************");


    }
    public static void printIntro(){
        System.out.println("Please enter your User ID first, then User Password:");
    }
    public static Librarian verifyLibrarianOnSystem(long id, String enterPass){
        for(Librarian librarian: librarianList ){
            if( id == (librarian.getLibId()) && enterPass.equals(librarian.getPassword()) )
            return librarian;
        }
        return null;
    }
    public static void printMenu(){
        int option;
        do {
            System.out.println("Please choose your option:");
            System.out.println("1: Add New Book");
            System.out.println("2: Remove books");
            System.out.println("3: Search books by id");
            System.out.println("4: Search books by name");
            System.out.println("5: Search books by author");
            System.out.println("6: List books by author");
            System.out.println("7: List all books");
            System.out.println("0: Exit");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    addBook();
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
            
        } while (option != 0);
    }
    public static void addBook(){
        System.out.println("Please enter book information");
        System.out.println("Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Book Name: ");
        String bookName = scanner.nextLine();
        System.out.println("Author Name: ");
        String authorName = scanner.nextLine();
        System.out.println("Author Lastname: ");
        String authorLastname = scanner.nextLine();
        System.out.println("Book Price: ");
        int bookPrice = scanner.nextInt();
        Status status = Status.AVAILABLE;
        System.out.println("Book Edition: ");
        scanner.nextLine();
        String edition = scanner.nextLine();
        System.out.println("Book Date of Purchase: ");
        String dateOfPurchase = scanner.nextLine();
        Author author = new Author(authorName,authorLastname);
        Book newBook = new Book(bookId,author,bookName,bookPrice,status,edition,dateOfPurchase);
        System.out.println("Book added succesfully!");
        System.out.println(trinityCollegeLibrary.getAvailableBooks());
        System.out.println(trinityCollegeLibrary.getLentBooks());
    };
}
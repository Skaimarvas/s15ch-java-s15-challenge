package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.book.Status;
import com.workintech.person.Reader;

import java.util.*;


/**Notlar
 * Kitapları sadece librarian library aracılığıyla vermeli
 * Sadece üyelere vermeli;
 * librarian ve library aynı pakete koyulabilir mi?
 *
 *
 *
 */
public class Library {
    //Encapsulation:
    private String name;
    private Map<Long, Book> availableBooks;
    private Map<Long, Book> lentBooks;
    private Map<Long, MemberRecord> readers;
    private Map<Long, Librarian> librarians;
    public Library(String name) {
        this.availableBooks = new HashMap<>();
        this.name = name;
        this.lentBooks = new HashMap<>();
        this.readers = new HashMap<>();
        this.librarians = new HashMap<>();
    }
    public Map<Long, MemberRecord> getReaders() {
        return readers;
    }
    public String getName() {
        return name;
    }
    public boolean verifyLibrarian(Librarian librarian){
        if(this.getLibrarians().containsKey(librarian.getLibId())) return true;

        System.out.println("This librarian: " + this.getName() + " has not permisson in " + this.getName());
        return false;
    }
    public void addLibrarian(Librarian librarian){
        if(this.librarians.containsKey(librarian.getLibId())){
            System.out.println("The librarian: " + librarian.getName() + " " + librarian.getLastname() +  " is already exist");
        } else {
            this.librarians.put(librarian.getLibId(), librarian);
        }
    }
    protected boolean isBookAvailable(Book book){
        if(this.getAvailableBooks().containsKey(book.getBook_ID())){

            System.out.println("the book: " + book.getName() + " is already exist");
            return true;
        };
        return false;
    }
    protected boolean isBookLent(Book book){
        if(this.getLentBooks().containsKey(book.getBook_ID())) {
            System.out.println("the book: " + book.getName() + " is already exist");
            return true;
        };
        return false;
    }
    protected boolean isBookExist (Book book){
        if(isBookAvailable(book) && isBookLent(book)) return true;
        return false;
    }
    public Map<Long, Librarian> getLibrarians() {
        return librarians;
    }
    protected void recordMember(MemberRecord member){
        if(this.readers.containsKey(member.getMemberId())){
            System.out.println("This member is already exist");
        } else {
            this.readers.put(member.getMemberId(), member);
        }

    }
    public Map<Long, Book> getAvailableBooks() {
        return availableBooks;
    }
    public Map<Long, Book> getLentBooks() {
        return lentBooks;
    }
    public void newBook(Book book){
       if(!isBookExist(book) ){
           book.setStatus(Status.AVAILABLE);
           availableBooks.put(book.getBook_ID(), book);
       };
    }
    public Book getBookById (int id){
        for (Book book: this.getAvailableBooks().values()){
            if (book.getBook_ID() == id) {
                return book;
            }
        }
        return null;
    }
    public void removeBook(Book book){
        if(isBookExist(book)){
            book.setStatus(Status.NOT_IN_CATALOG);
            this.availableBooks.remove(book.getBook_ID());
            System.out.println("The book:" + book.getName() + "was succesfully deleted on the system ");
            book.changeOwner(new Reader(null,null));
        }
    }
    public void lentBook(Book book, Reader reader){
            reader.borrowedBooks(book);
            book.changeOwner(reader);
            book.setStatus(Status.ON_LOAN);
            availableBooks.remove(book.getBook_ID());
            lentBooks.put(book.getBook_ID(),book);
    }
    public void takeBackBook(Book book, Reader reader){
        reader.returnBook(book);
        availableBooks.put(book.getBook_ID(), book);
        lentBooks.remove(book.getBook_ID());

}
    public void showBook(){
        System.out.println("________________Available_Books_____________");
        if(!availableBooks.isEmpty()){
            for(Book book: availableBooks.values()){
                System.out.println(book);
            }
        } else {
            System.out.println("There are no available books");
        }
        System.out.println("_______________Lent_Books______________");
        if(!lentBooks.isEmpty()){
            for (Book book: lentBooks.values()){
                System.out.println(book);
            }
        } else {
            System.out.println("All books are available now");
        }

        System.out.println("_______________End_____________________");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(availableBooks, library.availableBooks) && Objects.equals(lentBooks, library.lentBooks);
    }
    @Override
    public int hashCode() {
        return Objects.hash(availableBooks, lentBooks);
    }
    @Override
    public String toString() {
        return "Library{" +
                "availableBooks=" + availableBooks +
                ", lentBooks=" + lentBooks +
                '}';
    }
}

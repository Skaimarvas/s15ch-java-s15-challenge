package com.workintech.library;
import com.workintech.book.Book;
import com.workintech.book.Status;
import com.workintech.person.Person;
import com.workintech.person.Reader;

import java.util.Iterator;
import java.util.Objects;


public class Librarian extends Person {
    private int deposit;
    private long libId;
    private String password;
    public Librarian(String name, String lastname, String password,long libId) {
        super(name, lastname);
        this.password = password;
        this.libId = libId;
        this.deposit = 0;
    }
    public void issueBook(Library library, Book book, MemberRecord memberRecord){
        System.out.println("------------------ISSUED-BOOK-TRANSACTION----------------------");
        //librarian kontrolü
        // memberkontrolü
        if(library.verifyLibrarian(this) && verifyMember(memberRecord,library) && library.getAvailableBooks().containsKey(book.getBook_ID())){
                memberRecord.incBookIssued();
                library.lentBook(book,memberRecord);
                createBill(memberRecord,book);
        } else if(library.getLentBooks().containsKey(book.getBook_ID())){
            //burada getOwner methodunu kullanacağız
            System.out.println("This book already has been lent to: " + book.getOwner().getName());
        }
        System.out.println("------------------ISSUED-BOOK-TRANSACTION-END------------------");
    }
    public void takeIssueBook(Library library, Book book, MemberRecord memberRecord){
        System.out.println("------------------ISSUED-BOOK-TRANSACTION----------------------");
        //librarian kontrolü
        // memberkontrolü
        if(library.verifyLibrarian(this) && verifyMember(memberRecord,library) && !library.isBookAvailable(book) && library.isBookLent(book)){
            memberRecord.decBookIssued();
            library.takeBackBook(book, memberRecord);
        } else if(library.getLentBooks().containsKey(book.getBook_ID())){
            //burada getOwner methodunu kullanacağız
            System.out.println("This book already has been lent to: " + book.getOwner().getName());
        }
        System.out.println("------------------ISSUED-BOOK-TRANSACTION-END------------------");
    }
    public boolean verifyMember(MemberRecord memberRecord, Library library){
        if(library.getReaders().containsKey(memberRecord.getMemberId())) return true;
        System.out.println("The reader: " + memberRecord.getName() + " " + memberRecord.getLastname() + " is not recorded in the system of " + library.getName());
        return false ;
    }
    public void updatedBookInfo(Book newbook, Library library){
        //Başta Iterator kullanmadığım için Concurrent hatası aldım.
        Iterator<Book> iterator = library.getAvailableBooks().values().iterator();
        System.out.println("---------------Updating-Book-Data------------------");
        while (iterator.hasNext()){
            Book book = iterator.next();
            if(book.getBook_ID() == newbook.getBook_ID()){
                System.out.println("Book Old Data: " + book);
                iterator.remove();

                System.out.println("Book New Data: " + newbook);
            }
        }
        library.getAvailableBooks().put(newbook.getBook_ID(), newbook);
        //Bu işlemi while içinde yaptığım için tekrar Concurrent hatası aldım .
        System.out.println("Available Books: " + library.getAvailableBooks());
        System.out.println("---------------Updating-Book-Data-End-------------");
    }
    public void searchBookbyID(int bookId,Library library){
        System.out.println("Search Result for: " + bookId );
        for(Book book: library.getAvailableBooks().values()){
            if( book.getBook_ID() == bookId ){
                System.out.println("Book: " + book);
            }
        };
        System.out.println("Search Result End for: " + bookId);
    }
    public void searchBookbyBookName(String bookname, Library library){
        System.out.println("Search Result for: " + bookname );
        for(Book book: library.getAvailableBooks().values()){
            if( book.getName().toLowerCase().toLowerCase().contains(bookname)){
                System.out.println("Book: " + book);
            }
        };
        System.out.println("Search Result End for: " + bookname);
    }
    public void searchBookbyAuthorName(String authorname, Library library){
        System.out.println("Search Result for: " + authorname );
        for(Book book: library.getAvailableBooks().values()){
            if( book.getAuthor().getName().toLowerCase().contains(authorname)){
                System.out.println("Book: " + book);
            }
        };
        System.out.println("Search Result End for: " + authorname);
    }
    public void searchBookbyAuthorLastName(String authorlastname, Library library){
        System.out.println("Searching Result for: " + authorlastname );
        for(Book book: library.getAvailableBooks().values()){
            if( book.getAuthor().getLastname().toLowerCase().contains(authorlastname)){
                System.out.println("Book: " + book);
            }
        };
        System.out.println("Search Result End for: " + authorlastname);
    }
    public void addMember(Library library, MemberRecord memberRecord){
        if(!library.getLibrarians().containsKey(this.getLibId())){
            System.out.println("The librarian: " + this.getName() + " " + this.getLastname() + " has no permission to do the transaction in " + library.getName());
        } else {
            library.recordMember(memberRecord);
            System.out.println("New member: " + memberRecord.getName() + " was saved on the system of " + library.getName());
        }
    }
    public void createBill(MemberRecord member, Book book){
        System.out.println("----------------------------");
        System.out.println("Invoice:");
        System.out.println("Username: " + member.getName());
        System.out.println("Book ID: " + book.getBook_ID());
        System.out.println("Book Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Member Credit: " + member.getCredit());
        System.out.println("Price: 25");
        member.payBill();
        System.out.println("Member Balance (After Transaction) : " + member.getCredit());
        System.out.println("----------------------------");
    }
    @Override
    public String getLastname() {
        return super.getLastname();
    }
    @Override
    public String getName(){
        return super.getName();
    }
    public long getLibId() {
        return libId;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public void whoYouAre() {
        System.out.println("Person is " + getClass().getSimpleName() + ": " + getName() + " " + getLastname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(this.getName(), librarian.getName()) || Objects.equals(this.getLastname(), librarian.getLastname()) || Objects.equals(this.getPassword(), librarian.getPassword());

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

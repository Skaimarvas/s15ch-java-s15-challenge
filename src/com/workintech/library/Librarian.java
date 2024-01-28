package com.workintech.library;
import com.workintech.book.Book;
import com.workintech.person.Person;
import com.workintech.library.Library;


public class Librarian extends Person {
    private long libId;
    private String password;
    public Librarian(String name, String lastname, String password,long libId) {
        super(name, lastname);
        this.password = password;
        this.libId = libId;
    }
    private Book searchBook(int bookId, String bookname, String authorname, String authorlastname, Library library){
        for(Book book: library.getAvailableBooks().values()){
            if(book.getAuthor().getName().equals(authorname) && book.getAuthor().getLastname().equals(authorlastname) || book.getBook_ID() == bookId || book.getName().equals(bookname)){
                return book;
            }
        };
        return new Book();
    }

    public void addMember(Library library, MemberRecord memberRecord){
        if(!library.getLibrarians().containsKey(this.getLibId())){
            System.out.println("The librarian: " + this.getName() + " " + this.getLastname() + " has no permission to do the transaction in " + library.getName());
        } else {
            library.recordMember(memberRecord);
            System.out.println("New member: " + memberRecord.getName() + " was saved on the system of " + library.getName());
        }
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

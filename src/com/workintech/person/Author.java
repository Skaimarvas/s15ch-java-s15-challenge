package com.workintech.person;

import com.workintech.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**Notlar:
 * Author constructor'unda this.books = new ArrayList<>(); oluşturmadığım
 * için nullPointer hatası aldım.
 */


public class Author extends Person {

    private List<Book> books;

    public Author(String name, String lastname) {
        super(name, lastname);
        this.books = new ArrayList<>();

    }

    public List<Book> getBooks() {
        return books;
    }

    public void addNewBook(Book book){

        if(!isAuthorHasBook(book)){
            books.add(book);
        } else {
            System.out.println("The author: " + this.getName() + " has already book.");
        }

    }

    private boolean isAuthorHasBook(Book book){
        for(Book book1: books){
            if (book1.getBook_ID() == book.getBook_ID()) {
                return true;
            }

        }
        return false;
    }

    public void showBook(){

        for(Book book: books){
            System.out.println("___________________________________________________");
            System.out.println("Book: " + book.get_title());
            System.out.println("Author: " + book.getAuthor().getName() + " " + book.getAuthor().getLastname());
            System.out.println("Edition: " + book.getEdition());
            System.out.println("Status: " + book.getStatus().getDescription());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Date of Purchase: " + book.getDateOfPurchase());
            System.out.println("__________________________________________________");

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Person is " + getClass().getSimpleName() + ": " + getName() + " " + getLastname());
    }


}

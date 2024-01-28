package com.workintech.person;

import com.workintech.book.Book;

import java.util.ArrayList;
import java.util.List;

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

    public void newBook(Book book){
        books.add(book);
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
    public void whoYouAre() {
        System.out.println("Person is " + getClass().getSimpleName() + ": " + getName() + " " + getLastname());
    }


}

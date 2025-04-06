package com.book.Service;

import com.book.model.BookDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

  List<BookDetails> booklist = new ArrayList<>();
  private long currId = 1;
    @Override
    public BookDetails addBook(BookDetails book) {
        book.setId(currId++);
        booklist.add(book);
        return book;
    }

    @Override
    public BookDetails findBook(long id) {

        for(BookDetails book: booklist){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<BookDetails> findAll() {
        return booklist;
    }

    @Override
    public boolean deleteBook(long id) {
        Iterator<BookDetails> iterator = booklist.iterator();
        while (iterator.hasNext()){
            BookDetails book = iterator.next();
            if (book.getId() == id){
                iterator.remove();
                return true;
            }

        }
        return false;
    }

    @Override
    public BookDetails updateBook(long id, BookDetails bookDetails) {
        BookDetails boo =  findBook(id);
       if(booklist.contains(boo)){
           BookDetails neBook = boo;
           neBook.setName(bookDetails.getName());
           neBook.setPrice(bookDetails.getPrice());
           return neBook;
       }
      return null;
    }




}

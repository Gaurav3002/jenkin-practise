package com.book.Service;

import com.book.model.BookDetails;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public BookDetails addBook(BookDetails bookDetails);
    public BookDetails findBook(long id);
    public List<BookDetails> findAll();
    public boolean deleteBook(long id);
    public BookDetails updateBook(long id, BookDetails bookDetails);
}

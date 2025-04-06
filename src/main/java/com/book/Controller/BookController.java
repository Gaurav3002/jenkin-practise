package com.book.Controller;


import com.book.Service.BookService;
import com.book.Service.BookServiceImpl;
import com.book.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {


    @Autowired
    private BookServiceImpl bookService;


    //display list of books
@GetMapping("/")
    public String viewHomePage(Model model){
        List<BookDetails> list= bookService.findAll();
        model.addAttribute("listBook",list);
        return "index";
    }
@GetMapping("/showBookForm")
public String showBookForm(Model model){
BookDetails bookd = new BookDetails();
model.addAttribute("book", bookd);
return "new_employee";
}

@PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") BookDetails book){
     bookService.addBook(book);
     return "redirect:/";
}

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model){
    BookDetails book = bookService.findBook(id);
        bookService.deleteBook(id);
        book.setId(id);
    model.addAttribute("book", book);
    bookService.deleteBook(id);
return "update_employee";
    }
@GetMapping("/deletebook/{id}")
public String deleteBook(@PathVariable(value = "id") long id, Model model){
   bookService.deleteBook(id);
   return "redirect:/";

}

}

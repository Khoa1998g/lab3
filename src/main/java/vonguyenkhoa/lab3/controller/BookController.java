package vonguyenkhoa.lab3.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vonguyenkhoa.lab3.entity.Book;
import vonguyenkhoa.lab3.services.BookService;
import vonguyenkhoa.lab3.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "not found";
        } else {
            bookService.deleteBook(id);
            return "redirect:/books";
        }
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return "not found";

        } else {
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("book", book);
            return "book/edit";
        }
    }
    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        Book book = bookService.getBookById(id);

        if (book != null) {
            bookService.saveBook(book);
            return "redirect:/books";
        } else {
            return "redirect:/books";
        }
    }

}

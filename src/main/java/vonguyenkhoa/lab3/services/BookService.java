package vonguyenkhoa.lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vonguyenkhoa.lab3.entity.Book;
import vonguyenkhoa.lab3.repository.IBookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public void saveBook(Book book){
        bookRepository.save(book);
    }
}

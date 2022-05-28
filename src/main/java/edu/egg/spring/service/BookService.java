package edu.egg.spring.service;

import edu.egg.spring.entity.Book;
import edu.egg.spring.repository.BookRepository;
import java.util.List;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    @Transactional
    public void create(Book bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setCopies(bookDto.getCopies());
        book.setBorrowed_copies(bookDto.getBorrowed_copies());
        book.setRemaining_copies(bookDto.getRemaining_copies());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setAlta(bookDto.isAlta());

        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

     @Transactional
    public void update(Book bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).get();
        
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setCopies(bookDto.getCopies());
        book.setBorrowed_copies(bookDto.getBorrowed_copies());
        book.setRemaining_copies(bookDto.getRemaining_copies());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setAlta(bookDto.isAlta());
        
        bookRepository.save(book);
        
    }
    
    @Transactional(readOnly= true)
    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }

        @Transactional
    public void deletedById(Integer id) {
        bookRepository.deleteById(id);
    }
}

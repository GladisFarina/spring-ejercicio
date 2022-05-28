
 package edu.egg.spring.controller;

import edu.egg.spring.entity.Author;
import edu.egg.spring.entity.Book;
import edu.egg.spring.entity.Publisher;
import edu.egg.spring.service.BookService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ModelAndView getBooks(){
        ModelAndView mav =new ModelAndView("book-table");
        mav.addObject("books", bookService.getAll());
        return mav;
    }
    
    @GetMapping("/form")
    public ModelAndView getForm(){
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("book",new Book());
        mav.addObject("action","create");
        return mav;
        
    }
    
    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("books", bookService.getById(id));
        mav.addObject("action","update");
        return mav;
    }
    
    @PostMapping("/create")
    public ModelAndView create(@Valid Book book, Errors errors){
        ModelAndView mav = new ModelAndView("redirect :/books");
        if(errors.hasErrors()){
             mav.addObject("book",book);
             mav.addObject("action","create");
                mav.setViewName("book-form");
            return mav;
        }
        bookService.create(book);
        return mav;
    }
    
    @PostMapping("/update")
    public ModelAndView update (@Valid Book book ,Errors errors){
        ModelAndView mav = new ModelAndView("redirect:/books");
        if(errors.hasErrors()){
            mav.addObject("book",book);
            mav.addObject("action","update");
            mav.setViewName("book-form");
            return mav;
        }
        bookService.update(book);
        return mav;
    
}
    @PostMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("redirect:/books");
        bookService.deletedById(id);
        return mav;
}
}
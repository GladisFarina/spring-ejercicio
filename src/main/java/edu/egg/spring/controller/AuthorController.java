package edu.egg.spring.controller;

import edu.egg.spring.entity.Author;
import edu.egg.spring.service.AuthorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public ModelAndView getAuthors(){
        ModelAndView mav = new ModelAndView("author-table");
        mav.addObject("authors", authorService.getAll());
        return mav;
        
    }
    @GetMapping("/form")
    public ModelAndView getForm(){
        ModelAndView mav = new ModelAndView("author-form");
        mav.addObject("author",new Author());
        mav.addObject("action","create");
        return mav;

    }
    @PostMapping("/create")
    public ModelAndView create(@Valid Author author, Errors errors){
        ModelAndView mav = new ModelAndView("redirect :/books");
        if(errors.hasErrors()){
             mav.addObject("author",author);
             mav.addObject("action","create");
                mav.setViewName("author-form");
            return mav;
        }
        authorService.create(author);
        return mav;
    }
}

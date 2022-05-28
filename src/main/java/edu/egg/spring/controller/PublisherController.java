
package edu.egg.spring.controller;

import edu.egg.spring.entity.Publisher;
import edu.egg.spring.service.PublisherService;
import javax.validation.Valid;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/publishers")
//@RequiredArgsConstructor
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    
    @GetMapping
    public ModelAndView getEditorial(){
        ModelAndView mav =new ModelAndView("publisher-table");
        mav.addObject("publishers", publisherService.getAll());
        return mav;
    }
     @GetMapping("/form")
    public ModelAndView getForm(){
        ModelAndView mav = new ModelAndView("author-form");
        mav.addObject("author",new Publisher());
        mav.addObject("action","create");
        return mav;

    }
    @PostMapping("/create")
    public ModelAndView create(@Valid Publisher publisher, Errors errors){
        ModelAndView mav = new ModelAndView("redirect :/books");
        if(errors.hasErrors()){
             mav.addObject("publisher",publisher);
             mav.addObject("action","create");
                mav.setViewName("publisher-form");
            return mav;
        }
        publisherService.create(publisher);
        return mav;
    }
}

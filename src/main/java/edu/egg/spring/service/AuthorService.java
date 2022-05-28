package edu.egg.spring.service;

import edu.egg.spring.entity.Author;
import edu.egg.spring.repository.AuthorRepository;
import java.util.List;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@RequiredArgsConstructor
public class AuthorService {
    
   @Autowired
    private AuthorRepository authorRepository;
    
    @Transactional
    public void create(Author authorDto){
        Author author= authorRepository.findById(authorDto.getId()).get();
        author.setName(author.getName());
        author.setAlta(author.isAlta());
        
        authorRepository.save(author);
    }
    
    @Transactional(readOnly=true)
    public List<Author> getAll(){
        return authorRepository.findAll();
        
    }

    
}

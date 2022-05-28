package edu.egg.spring.service;

import edu.egg.spring.entity.Publisher;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.egg.spring.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class PublisherService {

    
    @Autowired
    private PublisherRepository publisherRepository;
    
    @Transactional
    public void create(Publisher publisherDto) {
        Publisher publisher = publisherRepository.findById(publisherDto.getId()).get();
        publisher.setName(publisherDto.getName());
        publisher.setAlta(publisherDto.isAlta());
        
        publisherRepository.save(publisher);
    }
    
    @Transactional(readOnly=true)
    public List<Publisher> getAll() {
        return publisherRepository.findAll();

    }
}

package edu.egg.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@Setter
//@Getter
//@NoArgsConstructor
@Table(name="book",indexes={@Index(name="idx_book_title",columnList="book_title")})
public class Book implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="book_id" )
    @NotNull(message="id is required")
    private Integer id;
    
    @NotNull(message="isbn is required")
    @Column(name="book_isbn")
    private Long isbn;
    
    @NotBlank(message="title is required")
    @Column(name="book_title",length=100,nullable=false)
    private String title;
    
    @NotNull(message="year is required")
    @Column(name="book_year", columnDefinition="YEAR",nullable=false)
    private int year;
    
    @NotNull(message="copies is required")
    @Column(name="book_copies")
    private int copies;
    
    @NotNull(message="borrowed_copies is required")
    @Column(name="borrowed_copies")
    private int borrowed_copies;
    
    @NotNull(message="remaining_copies is required")
    @Column(name="remaining_copies")
    private int remaining_copies;
    
    
    @Column(name="alta_date",length=100,nullable=false)
    private boolean alta;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    //@NotBlank(message="author is required")
    @JoinColumn(name="author_id", referencedColumnName="author_id", nullable=false)
    private Author author;
    
    @ManyToOne(fetch = FetchType.EAGER)
    //@NotBlank(message="editorial is required")
    @JoinColumn(name="publisher_id", referencedColumnName = "publisher_id", nullable = false)
    private Publisher publisher;

    public Book() {
    }

    public Book(Integer id, Long isbn, String title, int year, int copies, int borrowed_copies, int remaining_copies, boolean alta, Author author, Publisher publisher) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.copies = copies;
        this.borrowed_copies = borrowed_copies;
        this.remaining_copies = remaining_copies;
        this.alta = alta;
        this.author = author;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getBorrowed_copies() {
        return borrowed_copies;
    }

    public void setBorrowed_copies(int borrowed_copies) {
        this.borrowed_copies = borrowed_copies;
    }

    public int getRemaining_copies() {
        return remaining_copies;
    }

    public void setRemaining_copies(int remaining_copies) {
        this.remaining_copies = remaining_copies;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    
}

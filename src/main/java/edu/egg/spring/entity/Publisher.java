package edu.egg.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
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
@Table(name="publisher",indexes={@Index(name="idx_publisher_name",columnList="publisher_name")})
public class Publisher implements Serializable {

    
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="publisher_id", nullable=false)
    @NotNull
    private Integer id;
    
    @NotBlank(message="name is required")
    @Column(name="publisher_name",length=100, nullable=false)
    private String name;
    
    @Column(name="alta_date")
    private boolean alta;

      public Publisher() {
    }

    public Publisher(Integer id, String name, boolean alta) {
        this.id = id;
        this.name = name;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
      
      
}

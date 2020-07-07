package ro.esolacad.javaspring.jpa.manyToOne;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.javaspring.jpa.Product;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean active;

//    @OneToMany
//    private Set<Product> products;
}

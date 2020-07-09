package ro.esolacad.javaspring.product;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    @NotNull
    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedBy
    @Column(updatable = false)
    private String userCreated;

    @LastModifiedBy
    private String userLastUpdated;

//    public String getDummyObject() {
//        return "dummy";
//    }

    public enum Status {
        INACTIVE, ACTIVE
    }
}

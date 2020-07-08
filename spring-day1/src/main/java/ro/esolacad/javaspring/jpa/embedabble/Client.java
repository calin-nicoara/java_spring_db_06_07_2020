package ro.esolacad.javaspring.jpa.embedabble;

import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal credit;

    private Integer numberOfOrders;

    @Embedded
    private ClientAddress clientAddress;

//    @Type(type = "org.hibernate.type.LocalDateTimeType")
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @Type(type = "org.hibernate.type.LocalDateTimeType")
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    public void prePersist() {
//        LocalDateTime now = LocalDateTime.now();
//        createdAt = now;
//        updatedAt = now;
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        updatedAt = LocalDateTime.now();
//    }

//    private String streetName;
//
//    private String number;
}

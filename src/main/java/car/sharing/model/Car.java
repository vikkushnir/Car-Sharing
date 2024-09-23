package car.sharing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@Table(name = "cars")
@SQLDelete(sql = "UPDATE cars SET is_deleted = true WHERE id=?")
@SQLRestriction(value = "is_deleted=false")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private int inventory;

    @Column(nullable = false)
    private BigDecimal dailyFee;

    @Column(nullable = false)
    private boolean isDeleted = false;

    public enum Type {
        SEDAN,
        SUV,
        HATCHBACK,
        UNIVERSAL
    }
}

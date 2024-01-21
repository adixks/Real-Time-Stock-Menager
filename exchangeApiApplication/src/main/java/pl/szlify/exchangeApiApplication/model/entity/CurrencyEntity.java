package pl.szlify.exchangeApiApplication.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "currency")
@Data
public class CurrencyEntity {

    @Id
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
}

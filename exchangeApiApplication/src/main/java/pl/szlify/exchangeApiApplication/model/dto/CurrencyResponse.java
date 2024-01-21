package pl.szlify.exchangeApiApplication.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CurrencyResponse {
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
}

package currencyprovider.model;

import lombok.Data;

import java.util.List;

import java.io.Serializable;

@Data
public class CurrencyDto implements Serializable {
    private String table;
    private String no;
    private String effectiveDate;
    private List<RateDto> rateDtos;
}

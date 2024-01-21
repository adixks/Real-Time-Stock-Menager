package currencypersistanceservice.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CurrencyDto implements Serializable {
    private String table;
    private String no;
    private String effectiveDate;
    private List<RateDto> rateDtos;
}

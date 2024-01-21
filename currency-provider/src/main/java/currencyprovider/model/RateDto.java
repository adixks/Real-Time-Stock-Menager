package currencyprovider.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RateDto implements Serializable {
    private String currency;
    private String code;
    private double bid;
    private double ask;
}

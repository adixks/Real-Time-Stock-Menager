package pl.szlify.exchangeApiApplication.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionInfoDto implements Serializable {
    private String email;
    private String details;
}

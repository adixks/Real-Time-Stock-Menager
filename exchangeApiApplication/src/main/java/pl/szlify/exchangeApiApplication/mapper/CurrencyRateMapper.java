package pl.szlify.exchangeApiApplication.mapper;

import org.springframework.stereotype.Component;
import pl.szlify.exchangeApiApplication.model.dto.CurrencyResponse;
import pl.szlify.exchangeApiApplication.model.entity.CurrencyRateEntity;

@Component
public class CurrencyRateMapper {

    public CurrencyResponse convertToCurrencyResponse(CurrencyRateEntity currencyRateEntity) {
        return new CurrencyResponse()
                .setCode(currencyRateEntity.getCurrencyCode())
                .setBid(currencyRateEntity.getBid())
                .setAsk(currencyRateEntity.getAsk());
    }
}

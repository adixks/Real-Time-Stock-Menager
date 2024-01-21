package currencypersistanceservice.mapper;

import currencypersistanceservice.model.dto.RateDto;
import currencypersistanceservice.model.entity.CurrencyRateEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CurrencyRateMapper {
    public CurrencyRateEntity mapToCurrencyRate(RateDto rateDto, String effectiveDate) {
        return new CurrencyRateEntity()
                .setCurrencyCode(rateDto.getCode())
                .setBid(rateDto.getBid())
                .setAsk(rateDto.getAsk())
                .setTimestamp(LocalDate.parse(effectiveDate).atStartOfDay());
    }
}

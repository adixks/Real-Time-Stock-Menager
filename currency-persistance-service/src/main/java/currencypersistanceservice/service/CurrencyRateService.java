package currencypersistanceservice.service;

import currencypersistanceservice.mapper.CurrencyRateMapper;
import currencypersistanceservice.model.dto.CurrencyDto;
import currencypersistanceservice.model.dto.RateDto;
import currencypersistanceservice.model.entity.CurrencyRateEntity;
import currencypersistanceservice.repository.CurrencyRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyRateService {
    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyRateMapper currencyRateMapper;

    public void saveOrUpdateCurrencyRate(CurrencyDto currencyDto){
        for (RateDto rateDto : currencyDto.getRateDtos()) {
            CurrencyRateEntity latestRate = currencyRateRepository.findTopByCurrencyCodeOrderByTimestampDesc(rateDto.getCode())
                    .orElse(new CurrencyRateEntity());
            CurrencyRateEntity newRate = currencyRateMapper.mapToCurrencyRate(rateDto, currencyDto.getEffectiveDate());
            if (latestRate.getId() != null) {
                newRate.setId(latestRate.getId());
            }
            currencyRateRepository.save(newRate);
        }
    }
}

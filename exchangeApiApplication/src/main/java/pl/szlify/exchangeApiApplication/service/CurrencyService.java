package pl.szlify.exchangeApiApplication.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeApiApplication.exception.LackOfInformationException;
import pl.szlify.exchangeApiApplication.model.dto.CurrencyResponse;
import pl.szlify.exchangeApiApplication.mapper.CurrencyRateMapper;
import pl.szlify.exchangeApiApplication.repository.CurrencyRateRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRateMapper currencyMapper;
    private final CurrencyRateRepository currencyRateRepository;

    public List<CurrencyResponse> getAllCurrencies() {
        return currencyRateRepository.findAll().stream()
                .map(currencyMapper::convertToCurrencyResponse)
                .collect(Collectors.toList());
    }

    public CurrencyResponse getCurrencyInfo(String code) {
        return currencyRateRepository.findByCurrencyCode(code)
                .map(currencyMapper::convertToCurrencyResponse)
                .orElseThrow(LackOfInformationException::new);
    }
}

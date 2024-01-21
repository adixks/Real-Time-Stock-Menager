package pl.szlify.exchangeApiApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeApiApplication.model.dto.ExchangeRequest;
import pl.szlify.exchangeApiApplication.model.entity.CurrencyRateEntity;
import pl.szlify.exchangeApiApplication.repository.CurrencyRateRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class ExchangeService {

    private final SendInfoService sendInfoService;
    private final CurrencyRateRepository currencyRepository;

    public ExchangeRequest performExchange(ExchangeRequest request) throws JsonProcessingException {
        CurrencyRateEntity fromCurrency = currencyRepository.findByCurrencyCode(request.getFromCurrency())
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency code: " + request.getFromCurrency()));
        CurrencyRateEntity toCurrency = currencyRepository.findByCurrencyCode(request.getToCurrency())
                .orElseThrow(() -> new IllegalArgumentException("Unknown currency code: " + request.getToCurrency()));

        BigDecimal rate = calculateExchangeRate(fromCurrency, toCurrency);
        request.setExchangeRate(rate.doubleValue());

        BigDecimal exchangedAmount = request.getOriginalAmount().multiply(rate);
        request.setExchangedAmount(exchangedAmount);

        String currentUserEmail = sendInfoService.getCurrentUserEmail();

        sendInfoService.sendTransactionInfoToQueue(request, currentUserEmail);

        return request;
    }

    private BigDecimal calculateExchangeRate(CurrencyRateEntity fromCurrency, CurrencyRateEntity toCurrency) {
        return toCurrency.getAsk().divide(fromCurrency.getBid(), 4, RoundingMode.HALF_UP);
    }
}

package pl.szlify.exchangeApiApplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szlify.exchangeApiApplication.model.dto.CurrencyResponse;
import pl.szlify.exchangeApiApplication.service.CurrencyService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<CurrencyResponse>> getAllCurrencies() {
        List<CurrencyResponse> currencies = currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CurrencyResponse> getCurrencyInfo(@PathVariable String code) {
        CurrencyResponse currencyResponse = currencyService.getCurrencyInfo(code);
        return currencyResponse != null ? ResponseEntity.ok(currencyResponse)
                : ResponseEntity.notFound().build();
    }
}

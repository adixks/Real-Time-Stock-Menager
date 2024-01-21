package pl.szlify.exchangeApiApplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szlify.exchangeApiApplication.model.dto.ExchangeRequest;
import pl.szlify.exchangeApiApplication.service.ExchangeService;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ExchangeRequest> performExchangeForAdmin(@RequestBody ExchangeRequest request) throws JsonProcessingException {
        ExchangeRequest updatedRequest = exchangeService.performExchange(request);
        return ResponseEntity.ok(updatedRequest);
    }

    @PostMapping
    public ResponseEntity<ExchangeRequest> performExchange(@RequestBody ExchangeRequest request) throws JsonProcessingException {
        ExchangeRequest updatedRequest = exchangeService.performExchange(request);
        return ResponseEntity.ok(updatedRequest);
    }
}

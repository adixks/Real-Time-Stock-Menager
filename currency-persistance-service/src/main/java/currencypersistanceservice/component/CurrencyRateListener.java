package currencypersistanceservice.component;

import currencypersistanceservice.model.dto.CurrencyDto;
import currencypersistanceservice.service.CurrencyRateService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CurrencyRateListener {
    private final CurrencyRateService currencyRateService;

    @RabbitListener(queues = "${queue.name}")
    public void receiveMessage(CurrencyDto currencyDto) {
        currencyRateService.saveOrUpdateCurrencyRate(currencyDto);
    }
}

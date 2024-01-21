package currencyprovider.component;

import currencyprovider.model.CurrencyDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RateSender {
    private final RabbitTemplate rabbitTemplate;

    public void send(CurrencyDto currencyDto) {
        try {
            rabbitTemplate.convertAndSend("currencyQueue", currencyDto);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send message to queue", e);
        }
    }
}

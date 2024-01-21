package currencyprovider.component;

import currencyprovider.client.NbpApiClient;
import currencyprovider.model.CurrencyDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CurrencyProvider {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyProvider.class);
    private final NbpApiClient nbpApiClient;
    private final RateSender rateSender;

    @Scheduled(cron = "0 */5 * * * *")
    public void fetchAndSendCurrencyData() {
        try {
            List<CurrencyDto> currencyDtoList = nbpApiClient.fetchCurrencyData();
            for (CurrencyDto currencyDto : currencyDtoList) {
                logger.info("Fetched currency data: " + currencyDto);
                rateSender.send(currencyDto);
            }
        } catch (Exception e) {
            logger.error("Failed to fetch and send currency data", e);
        }
    }
}

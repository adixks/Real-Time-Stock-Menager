package currencyprovider.client;

import currencyprovider.model.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "nbpApiClient", url = "${nbp.api.url}")
public interface NbpApiClient {

    @GetMapping("/tables/C?format=json")
    List<CurrencyDto> fetchCurrencyData();
}

package currencypersistanceservice.repository;

import currencypersistanceservice.model.entity.CurrencyRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRateEntity, Long> {
    Optional<CurrencyRateEntity> findTopByCurrencyCodeOrderByTimestampDesc(String currencyCode);
}

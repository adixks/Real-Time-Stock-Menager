package pl.szlify.exchangeApiApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szlify.exchangeApiApplication.model.entity.CurrencyRateEntity;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRateEntity, Long> {

    Optional<CurrencyRateEntity> findByCurrencyCode(String currencyCode);
}

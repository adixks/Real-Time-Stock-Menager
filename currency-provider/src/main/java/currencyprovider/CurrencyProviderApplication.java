package currencyprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class CurrencyProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyProviderApplication.class, args);
    }

    @Bean
    public Queue myQueue(@Value("${queue.name}") String queueName) {
        return new Queue(queueName, false);
    }
}

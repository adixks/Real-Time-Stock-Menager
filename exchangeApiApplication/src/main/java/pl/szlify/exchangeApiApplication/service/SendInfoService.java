package pl.szlify.exchangeApiApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeApiApplication.model.dto.TransactionInfoDto;
import pl.szlify.exchangeApiApplication.model.dto.ExchangeRequest;
import pl.szlify.exchangeApiApplication.model.entity.UserEntity;

@Service
@AllArgsConstructor
public class SendInfoService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private CustomUserDetailsService userDetailsService;

    public void sendTransactionInfoToQueue(ExchangeRequest request, String userEmail) throws JsonProcessingException {
        TransactionInfoDto transactionInfoDto = new TransactionInfoDto();
        transactionInfoDto.setEmail(userEmail);
        transactionInfoDto.setDetails("Transaction from " + request.getFromCurrency() + " to " + request.getToCurrency() +
                " - Original Amount: " + request.getOriginalAmount() + " " + request.getFromCurrency() +
                ", Exchanged Amount: " + request.getExchangedAmount() + " " + request.getToCurrency() +
                ", Exchange Rate: " + request.getExchangeRate());

        String jsonTransactionInfo = objectMapper.writeValueAsString(transactionInfoDto);
        rabbitTemplate.convertAndSend("mail_queue", jsonTransactionInfo);
    }

    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            UserEntity currentUser = userDetailsService.loadUserEntityByUsername(username);
            return currentUser.getEmail();
        }
        throw new IllegalStateException("Authentication is null");
    }
}

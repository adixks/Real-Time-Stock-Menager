package mailservice.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mailservice.dto.TransactionInfoDto;
import mailservice.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    private EmailService emailService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "mail_queue")
    public void receiveMessage(String jsonMessage) {
        TransactionInfoDto transactionInfoDto = parseJsonMessage(jsonMessage);
        emailService.sendEmail(transactionInfoDto);
    }

    private TransactionInfoDto parseJsonMessage(String jsonMessage) {
        try {
            return objectMapper.readValue(jsonMessage, TransactionInfoDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON message", e);
        }
    }
}

package mailservice.service;

import mailservice.dto.TransactionInfoDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(TransactionInfoDto transactionInfoDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(transactionInfoDto.getEmail());
        message.setSubject("Information about the currency exchange transaction");
        message.setText(createEmailBody(transactionInfoDto));
        mailSender.send(message);
    }

    private String createEmailBody(TransactionInfoDto transactionInfoDto) {
        return "Transaction details: " + transactionInfoDto.getDetails();
    }
}

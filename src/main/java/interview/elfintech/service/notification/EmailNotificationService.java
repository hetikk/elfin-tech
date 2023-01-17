package interview.elfintech.service.notification;

import interview.elfintech.repository.jpa.user.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailNotificationService implements NotificationService {

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String senderUsername;

    @Value("${spring.mail.password}")
    private String senderPassword;

    @Override
    public void notify(UserEntity user, String subject, String text) {
        log.info("Send email: to='{}', subject='{}', text='{}'", user.getEmail(), subject, text);

        // TODO: add TemplateEngine
        if (hasText(senderUsername) && hasText(senderPassword)) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(user.getEmail());
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text);
            emailSender.send(simpleMailMessage);
        }
    }

}

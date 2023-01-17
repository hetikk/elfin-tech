package interview.elfintech.delegate;

import interview.elfintech.repository.jpa.user.UserEntity;
import interview.elfintech.service.notification.NotificationService;
import interview.elfintech.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SendSuccessfulEmailDelegate implements JavaDelegate {

    private final UserService userService;
    private final NotificationService notificationService;

    public void execute(DelegateExecution execution) throws Exception {
        final String email = (String) execution.getVariable("email");
        UserEntity user = userService.getByEmail(email).get();

        notificationService.notify(user, "Registration", "You're registered");
    }

}
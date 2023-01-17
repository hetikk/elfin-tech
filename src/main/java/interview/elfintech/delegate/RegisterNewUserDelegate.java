package interview.elfintech.delegate;

import interview.elfintech.repository.jpa.user.UserEntity;
import interview.elfintech.service.domain.DomainService;
import interview.elfintech.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterNewUserDelegate implements JavaDelegate {

    private final UserService userService;
    private final DomainService domainService;

    public void execute(DelegateExecution execution) {
        final String email = (String) execution.getVariable("email");

        boolean availableEmailDomain = domainService.getAvailableEmailDomains().stream().anyMatch(email::endsWith);

        boolean emailAlreadyExists = userService.getByEmail(email).isPresent();
        // TODO: handle emailAlreadyExists

        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setAvailableEmailDomain(availableEmailDomain);
        user = userService.save(user);

        if (!availableEmailDomain) {
            log.info("New user is waiting for email confirmation (id={}, email={})", user.getId(), user.getEmail());
            throw new BpmnError("availableEmailDomainError");
        } else {
            log.info("New user is registered (id={}, email={})", user.getId(), user.getEmail());
        }
    }

}
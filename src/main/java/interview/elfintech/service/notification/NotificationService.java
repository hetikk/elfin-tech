package interview.elfintech.service.notification;

import interview.elfintech.repository.jpa.user.UserEntity;

public interface NotificationService {

    void notify(UserEntity user, String subject, String text);

}

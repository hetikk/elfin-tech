package interview.elfintech.service.user;

import interview.elfintech.repository.jpa.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity update(UserEntity user) {
        return userRepository.update(user);
    }

}

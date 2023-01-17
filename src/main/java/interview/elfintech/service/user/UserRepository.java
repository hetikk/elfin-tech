package interview.elfintech.service.user;

import interview.elfintech.repository.jpa.user.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> getById(Long id);

    Optional<UserEntity> getByEmail(String email);

    UserEntity save(UserEntity user);

    UserEntity update(UserEntity user);

}

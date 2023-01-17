package interview.elfintech.repository.jpa.user;

import interview.elfintech.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;

    @Override
    public Optional<UserEntity> getById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userDao.save(user);
    }

}

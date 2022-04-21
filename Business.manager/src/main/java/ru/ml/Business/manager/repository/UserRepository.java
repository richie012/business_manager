package ru.ml.Business.manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ml.Business.manager.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}


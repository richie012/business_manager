package ru.ml.Business.manager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ml.Business.manager.entities.User;

public interface user_rep extends CrudRepository<User, Integer> {
}

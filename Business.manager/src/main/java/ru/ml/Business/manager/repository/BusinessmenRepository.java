package ru.ml.Business.manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ml.Business.manager.entity.UserBusinessmen;
public interface BusinessmenRepository extends CrudRepository<UserBusinessmen, Long>
{
}

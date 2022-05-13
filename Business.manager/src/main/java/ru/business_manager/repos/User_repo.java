package ru.business_manager.repos;


import org.springframework.data.repository.CrudRepository;
import ru.business_manager.entities.UserMember;

import java.util.List;

public interface User_repo extends CrudRepository<UserMember, Long> {
    //List<UserMember> findByTag(String tag);
}

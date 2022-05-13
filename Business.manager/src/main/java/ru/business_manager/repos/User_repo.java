package ru.business_manager.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.business_manager.entities.UserMember;

import java.util.List;

public interface User_repo extends JpaRepository<UserMember, Long> {
    UserMember findByName(String name);
}

package com.cydeo.repository;

import com.cydeo.entity.Role;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    void deleteByUserName(String userName);

    User findByUserName(String userName);

    List<User> findByRole(Role role);

    List<User> findByRole_DescriptionIgnoreCase(String description);

}
package com.chetan.issuetracker.repository;

import com.chetan.issuetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    void deleteById(Long id);

    Optional<User> findByUserNameAndIdNot(String userName, Long id);

}


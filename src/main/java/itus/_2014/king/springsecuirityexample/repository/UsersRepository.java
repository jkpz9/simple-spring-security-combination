package itus._2014.king.springsecuirityexample.repository;

import itus._2014.king.springsecuirityexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public  interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);
}

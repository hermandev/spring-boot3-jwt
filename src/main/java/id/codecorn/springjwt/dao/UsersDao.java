package id.codecorn.springjwt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.codecorn.springjwt.entity.Users;

public interface UsersDao extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
}

package id.codecorn.springjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.codecorn.springjwt.entity.Roles;

public interface RolesDao extends JpaRepository<Roles, Long> {

}

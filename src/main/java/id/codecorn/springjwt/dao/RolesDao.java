package id.codecorn.springjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.codecorn.springjwt.entity.Roles;

@Repository
public interface RolesDao extends JpaRepository<Roles, Long> {

    Roles findByName(String string);

}

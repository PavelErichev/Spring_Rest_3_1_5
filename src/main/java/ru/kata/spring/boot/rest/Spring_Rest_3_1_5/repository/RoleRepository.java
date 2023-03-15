package ru.kata.spring.boot.rest.Spring_Rest_3_1_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot.rest.Spring_Rest_3_1_5.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
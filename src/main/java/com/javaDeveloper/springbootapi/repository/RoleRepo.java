package com.javaDeveloper.springbootapi.repository;

import com.javaDeveloper.springbootapi.model.Role;
import com.javaDeveloper.springbootapi.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleType name);
}

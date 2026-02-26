package com.javaDeveloper.springbootapi.config;

import com.javaDeveloper.springbootapi.model.Role;
import com.javaDeveloper.springbootapi.model.enums.RoleType;
import com.javaDeveloper.springbootapi.repository.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepo roleRepo;

    public RoleInitializer(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) {

        for (RoleType roleType : RoleType.values()) {
            if (roleRepo.findByName(roleType).isEmpty()) {
                roleRepo.save(new Role(roleType));
            }
        }

        System.out.println("Roles inserted successfully");
    }
}
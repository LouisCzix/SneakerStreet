package com.example.sneakers.repositories.role;

import com.example.sneakers.enums.ERole;
import com.example.sneakers.models.role.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);

}

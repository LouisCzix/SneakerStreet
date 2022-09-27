package com.example.sneakers.models.role;

import com.example.sneakers.enums.ERole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Document(collection = "roles")
public class Role implements GrantedAuthority {

    @Id
    private String id;
    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
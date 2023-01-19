package com.estudos.demo.model;


import com.estudos.demo.enums.ERoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="ROLES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @Column(name="ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private ERoleEnum role;

    @OneToMany(mappedBy = "role")
    private Set<UserRoles> rolesUser;
}

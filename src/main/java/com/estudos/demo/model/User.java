package com.estudos.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1)
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 6696470850771902132L;


    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private Long id;

    @Column(name = "email")
    @Size(max = 500)
    private String email;

    @Column(name = "password")
    @Size(max = 1000)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserRoles> userRoles;

}

package com.estudos.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "USER_ROLES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "seq_user_role",sequenceName = "seq_user_role",allocationSize = 1)

public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_user_role")
    @Column(name ="ID")
    private Long id;

    @JoinColumn(name = "ID_USER")
    @ManyToOne
    private User user;

    @JoinColumn(name = "ID_ROLES")
    @ManyToOne
    private Role role;
}

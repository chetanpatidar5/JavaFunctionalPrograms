package com.chetan.issuetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "USER")
public class User implements Serializable {
    private static final long serialVersionUID = -809187991924046844L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "FIST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "ACTIVE", columnDefinition = "boolean default false")
    private Boolean active;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    @JoinColumn(name = "ROLE_ID",nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "POS_ID",nullable = false)
    private Position position;


}

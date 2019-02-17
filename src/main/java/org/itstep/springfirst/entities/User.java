package org.itstep.springfirst.entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pass;


}

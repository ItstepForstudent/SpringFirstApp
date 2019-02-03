package org.itstep.springfirst.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private Long id;
    private String name;
    private String pass;
    private Timestamp registerDate;
}

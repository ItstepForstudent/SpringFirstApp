package org.itstep.springfirst.dao;

import org.itstep.springfirst.entities.User;

import java.util.List;

public interface UsersDAO {
    public List<User> getAll();
}

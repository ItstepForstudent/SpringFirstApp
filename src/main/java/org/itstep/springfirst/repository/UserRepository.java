package org.itstep.springfirst.repository;

import org.itstep.springfirst.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User getByName(String name);
}

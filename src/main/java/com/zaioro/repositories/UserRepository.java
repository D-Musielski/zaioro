package com.zaioro.repositories;

import com.zaioro.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Val on 2017-05-05.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}

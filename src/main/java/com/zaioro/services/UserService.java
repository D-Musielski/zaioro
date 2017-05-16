package com.zaioro.services;

import com.zaioro.models.User;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);

}

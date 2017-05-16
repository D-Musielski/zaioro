package com.zaioro.services;

import com.zaioro.models.Role;
import com.zaioro.models.User;
import com.zaioro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private List<Role> roles = new ArrayList<>();
    private Role role = new Role();

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        roles.add(role);
    }

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }


    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        User user = new User();
        user.setUsername(domainObject.getUsername());
        user.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        user.addRole(role);

        return userRepository.save(user);
    }
    @Override
    @Transactional
    public void delete(Integer id) {
        userRepository.delete(id);
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

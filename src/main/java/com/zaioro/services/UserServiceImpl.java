//package com.zaioro.services;
//
//import com.zaioro.models.User;
//import com.zaioro.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Val on 2017-05-05.
// */
//@Service
//@Profile("springdatajpa")
//public class UserServiceImpl implements UserService {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<?> listAll() {
//        List<User> users = new ArrayList<>();
//        userRepository.findAll().forEach(users::add);
//        return users;
//    }
//
//    @Override
//    public User getById(Integer id) {
//        return userRepository.findOne(id);
//    }
//
//    @Override
//    public User saveOrUpdate(User domainObject) {
//        return userRepository.save(domainObject);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Integer id) {
//        userRepository.delete(id);
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//}
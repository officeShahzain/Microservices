package com.User.Service.service;

import com.User.Service.entities.User;

import java.util.List;

public interface UserService
{
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}

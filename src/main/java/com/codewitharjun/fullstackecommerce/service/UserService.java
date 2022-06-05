package com.codewitharjun.fullstackecommerce.service;

import com.codewitharjun.fullstackecommerce.model.Role;
import com.codewitharjun.fullstackecommerce.model.User;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findUserByUserName(String username);

    @Transactional
        //Transaction is required when executing an update/delete query.
    void changeRole(String username, Role newRole);
}

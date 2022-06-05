package com.codewitharjun.fullstackecommerce.service;

import com.codewitharjun.fullstackecommerce.model.Role;
import com.codewitharjun.fullstackecommerce.model.User;
import com.codewitharjun.fullstackecommerce.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional //Transaction is required when executing an update/delete query.
    public void changeRole(String username,Role newRole) {
        userRepository.updateUserRole(username, newRole);
    }



}

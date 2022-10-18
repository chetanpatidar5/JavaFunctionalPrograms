package com.chetan.issuetracker.service.impl;

import com.chetan.issuetracker.dto.UserDTO;
import com.chetan.issuetracker.entity.Position;
import com.chetan.issuetracker.entity.Role;
import com.chetan.issuetracker.entity.User;
import com.chetan.issuetracker.exception.IssueTrackingException;
import com.chetan.issuetracker.repository.PositionRepository;
import com.chetan.issuetracker.repository.RoleRepository;
import com.chetan.issuetracker.repository.UserRepository;
import com.chetan.issuetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PositionRepository positionRepository;




    @Override
    public User add(UserDTO userDTO) {
        User user = userDTO.toUser();
        user.setPassword(user.getPassword());
        user.setPosition(positionRepository.findById(userDTO.getPositionId()).get());
        user.setRole(roleRepository.findById(userDTO.getRoleId()).get());
        user.setActive(false);
        return userRepository.save(user);
    }


    @Override
    public User edit(UserDTO userDTO) {
        User user = userDTO.toUser();
        user.setPassword(user.getPassword());
        user.setPosition(positionRepository.findById(userDTO.getPositionId()).get());
        user.setRole(roleRepository.findById(userDTO.getRoleId()).get());
        user.setActive(false);
        return userRepository.save(user);
    }
    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    @Override
    public List<User> find() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User delete(Long id) {
        User user = null;
        if (!userRepository.existsById(id)) {
            throw new IssueTrackingException("USER_NOT_FOUND");
        } else {
            userRepository.deleteById(id);
        }
        return user;
    }


    @Override
    public List<Role> findRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<Position> findPositions() {
        return positionRepository.findAll();
    }

}

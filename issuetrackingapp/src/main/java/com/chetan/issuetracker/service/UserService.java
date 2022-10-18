package com.chetan.issuetracker.service;

import com.chetan.issuetracker.dto.IssueDTO;
import com.chetan.issuetracker.dto.UserDTO;
import com.chetan.issuetracker.entity.*;

import java.util.List;

public interface UserService {


    User add(UserDTO userDTO);

    User edit(UserDTO userDTO);

    User findByUserName(String userName);

    List<User> find();

    User findById(Long id);

    User delete(Long id);

    List<Role> findRoles();

    List<Position> findPositions();

}



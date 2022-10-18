package com.chetan.issuetracker.service.impl;

import com.chetan.issuetracker.dto.IssueDTO;
import com.chetan.issuetracker.entity.Issues;
import com.chetan.issuetracker.entity.Status;
import com.chetan.issuetracker.entity.Type;
import com.chetan.issuetracker.entity.User;
import com.chetan.issuetracker.exception.IssueTrackingException;
import com.chetan.issuetracker.repository.IssueTrackerRepository;
import com.chetan.issuetracker.repository.StatusRepository;
import com.chetan.issuetracker.repository.TypeRepository;
import com.chetan.issuetracker.repository.UserRepository;
import com.chetan.issuetracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueTrackerRepository issueTrackerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private TypeRepository typeRepository;


    @Override
    public Issues add(IssueDTO issueDTO) {

        Issues issues = issueDTO.toIssues();
        issues.setUser(userRepository.getOne(issueDTO.getOwner()));
        issues.setAssignTo(userRepository.getOne(issueDTO.getAssignTo()));
        issues.setType(typeRepository.getOne(issueDTO.getType()));
        issues.setStatus(statusRepository.getOne(1l));
        return issueTrackerRepository.save(issues);
    }

    @Override
    public Issues edit(IssueDTO issueDTO) {
        Issues issues = issueDTO.toIssues();
        issues.setUser(userRepository.getOne(issueDTO.getOwner()));
        issues.setAssignTo(userRepository.getOne(issueDTO.getAssignTo()));
        issues.setType(typeRepository.getOne(issueDTO.getType()));
        issues.setStatus(statusRepository.getOne(issueDTO.getStatus()));
        return issueTrackerRepository.save(issues);
    }

    @Override
    public boolean delete(Long id) {
        if (!issueTrackerRepository.existsById(id)) {
            throw new IssueTrackingException("ISSUE_NOT_FOUND");
        } else {
            issueTrackerRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public List<Issues> findAll() {
        return issueTrackerRepository.findAll();
    }

    @Override
    public Issues find(Long id) {
        if (!issueTrackerRepository.existsById(id)) {
            throw new IssueTrackingException("ISSUE_NOT_FOUND");
        }
        return issueTrackerRepository.findById(id).get();
    }

    @Override
    public List<Issues> findByUser(Long id) {
        System.out.println(">>>>>>> from findByUser");
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new IssueTrackingException("USER_NOT_FOUND");
        } else {
            return issueTrackerRepository.findByUser(user);
        }
    }

    @Override
    public List<Issues> findByAssigned(Long id) {

        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new IssueTrackingException("USER_NOT_FOUND");
        } else {
            return issueTrackerRepository.findByAssignTo(user);
        }
    }


    @Override
    public List<Type> findAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public List<Status> findAllStatus() {
        return statusRepository.findAll();
    }


}

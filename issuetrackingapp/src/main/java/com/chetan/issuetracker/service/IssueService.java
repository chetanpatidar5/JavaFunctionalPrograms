package com.chetan.issuetracker.service;

import com.chetan.issuetracker.dto.IssueDTO;
import com.chetan.issuetracker.entity.Issues;
import com.chetan.issuetracker.entity.Status;
import com.chetan.issuetracker.entity.Type;

import java.util.List;

public interface IssueService {

    Issues add(IssueDTO issueDTO);

    Issues edit(IssueDTO issueDTO);

    boolean delete(Long id);

    List<Issues> findAll();

    Issues find(Long id);

    List<Issues> findByUser(Long id);

    List<Issues> findByAssigned(Long id);

    List<Type> findAllTypes();

    List<Status> findAllStatus();
}

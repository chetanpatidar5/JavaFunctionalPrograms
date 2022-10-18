package com.chetan.issuetracker.repository;

import com.chetan.issuetracker.entity.Issues;
import com.chetan.issuetracker.entity.Status;
import com.chetan.issuetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueTrackerRepository extends JpaRepository<Issues, Long> {

    void deleteById(Issues issues);

    List<Issues> findByUser(User user);

    List<Issues> findByAssignTo(User user);

    List<Issues> findByAssignToAndStatus(User user, Status status);
}

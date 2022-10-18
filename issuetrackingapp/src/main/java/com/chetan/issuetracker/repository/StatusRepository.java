package com.chetan.issuetracker.repository;

import com.chetan.issuetracker.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}

package com.chetan.issuetracker.repository;

import com.chetan.issuetracker.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
}

package com.chetan.issuetracker.repository;

import com.chetan.issuetracker.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}

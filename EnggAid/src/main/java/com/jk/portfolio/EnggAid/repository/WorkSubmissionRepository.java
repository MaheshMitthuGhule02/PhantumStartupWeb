package com.jk.portfolio.EnggAid.repository;

import com.jk.portfolio.EnggAid.model.WorkSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSubmissionRepository extends JpaRepository<WorkSubmission, Long> {
}
package com.jk.portfolio.EnggAid.service;

import com.jk.portfolio.EnggAid.model.WorkSubmission;
import com.jk.portfolio.EnggAid.repository.WorkSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkSubmissionService {

    @Autowired
    private WorkSubmissionRepository workSubmissionRepository;

    public void saveWorkSubmission(WorkSubmission workSubmission) {
        workSubmissionRepository.save(workSubmission);
    }

    public WorkSubmission findById(Long id) {
        return workSubmissionRepository.findById(id).orElse(null);
    }
}

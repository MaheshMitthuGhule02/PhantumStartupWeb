package com.jk.portfolio.EnggAid.controller;

import com.jk.portfolio.EnggAid.model.WorkSubmission;
import com.jk.portfolio.EnggAid.repository.WorkSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private WorkSubmissionRepository workSubmissionRepository;

    @GetMapping("/admin/submissions")
    public String viewSubmissions(Model model) {
        List<WorkSubmission> submissions = workSubmissionRepository.findAll();
        model.addAttribute("submissions", submissions);
        return "admin/submissions";
    }

    @GetMapping("/admin/download/{id}")
    public ResponseEntity<byte[]> downloadfile(@PathVariable Long id) {
        WorkSubmission submission = workSubmissionRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=project_file_" + id + ".pdf")
                .body(submission.getProjecctFile());
    }
    }



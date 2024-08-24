package com.jk.portfolio.EnggAid.controller;

import com.jk.portfolio.EnggAid.model.WorkSubmission;
import com.jk.portfolio.EnggAid.service.WorkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Autowired
    private WorkSubmissionService workSubmissionService;

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        WorkSubmission workSubmission = workSubmissionService.findById(id);
        byte[] fileData = workSubmission.getProjectFile();

        if (fileData != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("Project.pdf").build());

            return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

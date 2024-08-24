package com.jk.portfolio.EnggAid.controller;

import com.jk.portfolio.EnggAid.model.WorkSubmission;
import com.jk.portfolio.EnggAid.service.WorkSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class WorkSubmissionController {

    @Autowired
    private WorkSubmissionService workSubmissionService;

    @PostMapping("/submitProject")
    public String submitProject(
            @RequestParam("name") String name,
            @RequestParam("mobile") String mobile,
            @RequestParam("email") String email,
            @RequestParam("department") String department,
            @RequestParam("college") String college,
            @RequestParam("projectFile") MultipartFile projectFile,
            @RequestParam("projectDescription") String projectDescription,
            @RequestParam("workDescription") String workDescription,
            RedirectAttributes redirectAttributes) {

        WorkSubmission workSubmission = new WorkSubmission();
        workSubmission.setName(name);
        workSubmission.setMobile(mobile);
        workSubmission.setEmail(email);
        workSubmission.setDepartment(department);
        workSubmission.setCollege(college);
        workSubmission.setProjectDescription(projectDescription);
        workSubmission.setWorkDescription(workDescription);

        try {
            // Handling file upload and converting to byte array
            if (!projectFile.isEmpty()) {
                workSubmission.setProjectFile(projectFile.getBytes());
            } else {
                redirectAttributes.addFlashAttribute("message", "Please upload a project file.");
                return "redirect:/work";
            }
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "File upload failed due to an error!");
            return "redirect:/work";
        }

        try {
            // Save the work submission data to the database
            workSubmissionService.saveWorkSubmission(workSubmission);
            redirectAttributes.addFlashAttribute("message", "Project submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to submit project. Please try again.");
            return "redirect:/work";
        }

        return "redirect:/work";
    }
}

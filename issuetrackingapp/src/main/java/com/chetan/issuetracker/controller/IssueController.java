package com.chetan.issuetracker.controller;


import com.chetan.issuetracker.dto.IssueDTO;
import com.chetan.issuetracker.entity.Issues;
import com.chetan.issuetracker.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Issues")
public class IssueController {

    @Autowired
    private IssueService issueService;


    @PostMapping("/addIssue")
    public ResponseEntity<Issues> addIssues( @RequestBody IssueDTO issues) {

        Issues getIssues = issueService.add(issues);

        return new ResponseEntity<>(getIssues, HttpStatus.CREATED);
    }

    @PutMapping("/updateIssue/{id}")
    public ResponseEntity<Issues> edit(@PathVariable Long id, @RequestBody IssueDTO issues) {

        issues.setId(id);
        Issues getIssues = issueService.edit(issues);

        return new ResponseEntity<>(getIssues, HttpStatus.OK);
    }

    @DeleteMapping("/deleteIssue/{id}")
    public ResponseEntity<Issues> deleteIssue(@PathVariable Long id) {
        issueService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/getAllIssues")
    public ResponseEntity<List<Issues>> getIssues() {

        List<Issues> getAllIssues = issueService.findAll();

        return new ResponseEntity<>(getAllIssues, HttpStatus.OK);
    }

    @GetMapping("/assinged/{id}")
    public ResponseEntity<List<Issues>> getByAssinged(@PathVariable Long id) {
        List<Issues> issueId = issueService.findByAssigned(id);
        return new ResponseEntity<>(issueId, HttpStatus.OK);
    }

}

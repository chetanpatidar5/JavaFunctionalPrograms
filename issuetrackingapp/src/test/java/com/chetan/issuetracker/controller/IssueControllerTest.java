package com.chetan.issuetracker.controller;


import com.chetan.issuetracker.dto.IssueDTO;
import com.chetan.issuetracker.entity.Issues;
import com.chetan.issuetracker.service.IssueService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IssueControllerTest {



    private IssueController issueController = new IssueController();

    private IssueService issueService = Mockito.mock(IssueService.class);


 /*   @Test
    public void testIssueController() {
        IssueDTO issueDTO=new IssueDTO();
        Issues issues = new Issues();
        issueController.addIssues(issueDTO);


    }*/

}

package com.chetan.issuetracker.dto;


import com.chetan.issuetracker.entity.Issues;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class IssueDTO {

    private Long id;
    private String title;
    private String description;
    @NonNull
    private Long owner;
    private Long assignTo;
    private Long type;
    private Long status;

    public Issues toIssues() {
        Issues issues = new Issues();
        issues.setId(this.id);
        issues.setTitle(this.title);
        issues.setDescription(this.description);
        return issues;
    }

}

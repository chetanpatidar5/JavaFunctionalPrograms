package com.chetan.issuetracker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ISSUES")
public class Issues implements Serializable {
    private static final long serialVersionUID = -8091879091924046848L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ISSUE_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCPTION")
    private String description;

    @Column(name = "ATTACHMENT")
    private String attachment;

    //    @JsonBackReference(value = "owner")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;

    //    @JsonBackReference(value = "assignTo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "ASSIGN_TO",nullable = false)
    private User assignTo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne
    @JoinColumn(name = "STATUS_ID",nullable = false)
    private Status status;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne
    @JoinColumn(name = "TYPE_ID",nullable = false)
    private Type type;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
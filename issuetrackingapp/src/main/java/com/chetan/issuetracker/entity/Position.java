package com.chetan.issuetracker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "POSTION")
public class Position implements Serializable {
    private static final long serialVersionUID = -8091879091924046847L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POS_ID")
    private Long id;

    @Column(name = "POS_KEY")
    private String key;

    @Column(name = "DESCPTION")
    private String descption;

}
package com.joshua.com.relationshipCRUD.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Page implements Serializable {
    @Id
    @SequenceGenerator(
            name = "page_sequence",
            sequenceName = "page_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "page_sequence")
    private Long id;
    @Column(
            columnDefinition = "TEXT",
            nullable = false
    )
    private int number;
    @Column(
            columnDefinition = "TEXT"
    )
    private String content;
    @Column(
            columnDefinition = "TEXT"
    )
    private String chapter;

    @JoinColumn(name = "book_id")
    private Long book_id;

    private String postedBy;
    private String postedFlag;
    private Date postedTime;
    private String modifiedBy;
    private String modifiedFlag;
    private Date modifiedTime;
    private String verifiedBy;
    private String verifiedFlag;
    private Date verifiedTime;
    private String deletedBy;
    private String deletedFlag;
    private Date deletedTime;

}

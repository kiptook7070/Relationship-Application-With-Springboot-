package com.joshua.com.relationshipCRUD.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "tbl_pages"
)
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
    @Column(
            columnDefinition = "INT",
            nullable = false
    )
    private Long book_id;
    @Column(length = 30, nullable = false)
    private String postedBy;
    @Column(nullable = false)
    private String postedFlag = "Y";
    @Column(nullable = false)
    private Date postedTime;
    private String modifiedBy;
    private String modifiedFlag = "N";
    private Date modifiedTime;
    private String verifiedBy;
    private String verifiedFlag = "N";
    private Date verifiedTime;
    private String deletedBy;
    private String deletedFlag = "N";
    private Date deletedTime;
}

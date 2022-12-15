package com.joshua.com.relationshipCRUD.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joshua.com.relationshipCRUD.pages.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "books"
)
public class Book implements Serializable {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    @Column(
            length = 8,
            nullable = false
    )
    private String entityId;
    @Column(
            columnDefinition = "TEXT",
            length = 255,
            nullable = false
    )
    private String title;
    @Column(
            columnDefinition = "TEXT",
            length = 255,
            nullable = false
    )
    private String author;
    @Column(
            columnDefinition = "TEXT",
            length = 255,
            nullable = false,
            unique = true
    )
    private String isbn;
    @OneToMany(
            mappedBy = "book",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Page>pages;

    //*****************Operational Audit *********************
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

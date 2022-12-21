package com.joshua.com.relationshipCRUD.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joshua.com.relationshipCRUD.pages.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
            nullable = false
    )
    private String title;
    @Column(
            columnDefinition = "TEXT",
            nullable = false
    )
    private String author;
    @Column(
            columnDefinition = "TEXT",
            nullable = false,
            unique = true
    )
    private String isbn;

    //    Relationship with  PAGES
    @OneToMany(targetEntity = Page.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Page> pages;

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

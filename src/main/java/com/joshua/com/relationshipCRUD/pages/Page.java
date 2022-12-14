package com.joshua.com.relationshipCRUD.pages;

import com.joshua.com.relationshipCRUD.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "pages"
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
            generator = "page_sequence"
    )
    private Long id;
    @Column(
            columnDefinition = "INT",
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
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "book_id",
            nullable = false
    )
    private Book book;
}

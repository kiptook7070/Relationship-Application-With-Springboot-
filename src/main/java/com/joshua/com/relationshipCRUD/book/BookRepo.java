package com.joshua.com.relationshipCRUD.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Optional<Book> findBookById(Long id);
    Optional<Book> findBookByIdAndDeletedFlag(Long id, String flag);
}

package com.joshua.com.relationshipCRUD.pages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepo extends JpaRepository<Page, Long> {

    Optional<Page> findPageById(Long id);
    Optional<Page> findPageByNumber(int number);
}

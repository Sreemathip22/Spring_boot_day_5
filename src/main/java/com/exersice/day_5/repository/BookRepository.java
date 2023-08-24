package com.exersice.day_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exersice.day_5.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
package com.curso.v0.dao;

import java.util.List;

import com.curso.v0.entity.Book;

// DAO base interface
public interface BookDAO {

    void save(Book theBook);

    Book findById(Integer id);

    List<Book> findAll();

    List<Book> findByAuthor(String theAuthor);

    void update(Book theBook);

    void delete(Integer id);

    int deleteAll();
}

package com.curso.v0.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.v0.entity.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Book theBook) {
    	System.out.println("Save Book");
        entityManager.persist(theBook); //<==JPA
    }

    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class, id);//<==JPA
    }

    @Override
    public List<Book> findAll() {
        // create query
        TypedQuery<Book> theQuery = entityManager.createQuery("FROM Book", Book.class);

        // return query results
        return theQuery.getResultList();//<==JPA
    }

    @Override
    public List<Book> findByAuthor(String theAuthor) {
        // create query
        TypedQuery<Book> theQuery = entityManager.createQuery(
                                        "FROM Book WHERE author=:theData", Book.class);

        // set query parameters
        theQuery.setParameter("theData", theAuthor);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Book theBook) {
        entityManager.merge(theBook); //<==JPA
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        Book theBook = entityManager.find(Book.class, id);

        // delete the student
        entityManager.remove(theBook);//<==JPA
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Book").executeUpdate(); //<==JPA
        entityManager.createNativeQuery("ALTER TABLE Book AUTO_INCREMENT = 1").executeUpdate();
        
        return numRowsDeleted;
    }
}











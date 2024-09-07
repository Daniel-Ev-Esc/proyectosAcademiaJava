package com.curso.v0.CrudJPA.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import com.curso.v0.CrudJPA.entity.Timecard;

@Repository
public class TimecardDAOImpl implements TimecardDAO {
	
	private EntityManager entityManager;

	@Autowired
	public TimecardDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Timecard> findAll() {
		
		TypedQuery<Timecard> theQuery = entityManager.createQuery("from Timecard", Timecard.class);
		
		List<Timecard> timecards = theQuery.getResultList();
		
		return timecards;
	}
	
	@Override
	public Timecard findById(long theId) {
		Timecard theTimecard = entityManager.find(Timecard.class, theId);
		
		return theTimecard;
	}
	
	@Override
	public List<Timecard> findByDepartment(String department) {
		TypedQuery<Timecard> theQuery = entityManager.createQuery("SELECT t FROM Timecard t WHERE t.department = :departmentName", Timecard.class);
	    
	    theQuery.setParameter("departmentName", department);
		
		List<Timecard> timecards = theQuery.getResultList();
		
		return timecards;
	}
	
	@Override
    public Timecard save(Timecard theTimecard) {

        Timecard dbTimecard = entityManager.merge(theTimecard);

        return dbTimecard;
    }

    @Override
    public void deleteById(long theId) {

        Timecard theTimecard = entityManager.find(Timecard.class, theId);

        entityManager.remove(theTimecard);
    }
}

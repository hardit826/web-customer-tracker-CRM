package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entitypackage.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers()
	{
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//Query the customer from db
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get the list from the query by executing
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer)
	{
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer finally
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomers(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}

	@Override
	public void delete(int theId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}
}

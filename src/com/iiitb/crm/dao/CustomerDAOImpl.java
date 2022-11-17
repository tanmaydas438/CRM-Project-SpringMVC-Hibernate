package com.iiitb.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iiitb.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers()
	{
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> list=query.getResultList();
		return list;
	}
	
	@Override
	public void addCustomer(Customer customer)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
	@Override
	public Customer getCustomerById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Customer c=session.get(Customer.class, id);
		return c;
	}
	
	@Override
	public void deleteCustomer(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Customer c=session.get(Customer.class, id);
		session.delete(c);
	}
	
	@Override
	public List<Customer> search(String theSearchName)
	{
		Session currentSession=sessionFactory.getCurrentSession();
Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
	}
}

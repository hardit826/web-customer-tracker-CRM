package com.springdemo.dao;

import java.util.List;
import com.springdemo.entitypackage.Customer;

public interface CustomerDAO 
{
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void delete(int theId);
}

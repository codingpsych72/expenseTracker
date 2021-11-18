package com.prj.expenseTracker.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prj.expenseTracker.model.Userdetails;

public interface UserdetailsService {
	List<Userdetails> getAllEmployees();
	void saveEmployee(Userdetails employee);
	Userdetails getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Userdetails> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

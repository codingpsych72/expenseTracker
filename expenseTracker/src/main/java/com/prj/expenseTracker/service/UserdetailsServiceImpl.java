package com.prj.expenseTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prj.expenseTracker.model.Userdetails;
import com.prj.expenseTracker.repository.UserdetailsRepository;

@Service
public class UserdetailsServiceImpl implements UserdetailsService {

	@Autowired
	private UserdetailsRepository employeeRepository;

	@Override
	public List<Userdetails> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Userdetails employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Userdetails getEmployeeById(long id) {
		Optional<Userdetails> optional = employeeRepository.findById(id);
		Userdetails employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Userdetails> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}

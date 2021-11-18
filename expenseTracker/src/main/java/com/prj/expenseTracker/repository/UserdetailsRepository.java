package com.prj.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.expenseTracker.model.Userdetails;

@Repository
public interface UserdetailsRepository extends JpaRepository<Userdetails, Long>{

}

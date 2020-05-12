package com.silesbonilla.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.silesbonilla.springboot.cruddemo.entity.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

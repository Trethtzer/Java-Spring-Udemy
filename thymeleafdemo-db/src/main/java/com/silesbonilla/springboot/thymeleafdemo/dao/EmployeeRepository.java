package com.silesbonilla.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.silesbonilla.springboot.thymeleafdemo.entity.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

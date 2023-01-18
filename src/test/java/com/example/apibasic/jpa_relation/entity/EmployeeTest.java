package com.example.apibasic.jpa_relation.entity;

import com.example.apibasic.jpa_relation.repository.DepartmentRepository;
import com.example.apibasic.jpa_relation.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    void empTest1() {

        Department dept1 = Department.builder()
                .deptName("개발부")
                .build();
        Department dept2 = Department.builder()
                .deptName("영업부")
                .build();

        Employee emp1 = Employee.builder()
                .empName("뽀삐")
                .department(dept2)
                .build();

        departmentRepository.save(dept1);
        departmentRepository.save(dept2);

        employeeRepository.save(emp1);
    }

    @Test
    void empTest2() {

        Department dept1 = Department.builder()
                .deptName("개발부")
                .build();
        Department dept2 = Department.builder()
                .deptName("영업부")
                .build();

        Employee emp1 = Employee.builder()
                .empName("뽀삐")
                .department(dept2)
                .build();

        departmentRepository.save(dept1);
        departmentRepository.save(dept2);

        employeeRepository.save(emp1);

        List<Employee> all = employeeRepository.findAll();

        all.forEach(System.out::println);


    }

}
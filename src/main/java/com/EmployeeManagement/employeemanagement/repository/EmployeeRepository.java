package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Spring JPARepository burada kullanılır
*  JPARepository ile özel arama methodları oluşturulabilir.*/

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity getByFirstNameAndLastName(String firstName, String lastName);

    Page<EmployeeEntity> findAllByTimeSheetsIsNotNull(Pageable pageable);

}

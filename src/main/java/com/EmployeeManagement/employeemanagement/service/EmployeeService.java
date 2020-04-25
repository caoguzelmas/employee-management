package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*Bu interface üzerinde bu interfacei implemente edecek Class için methodlar oluşturulur.*/

@Service
public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO employee);

    EmployeeDTO getById(Long id);

    Boolean delete(Long id);

    EmployeeDTO getByName(EmployeeDTO employee);

    EmployeeDTO update(Long id, EmployeeDTO employee);

    Page<EmployeeEntity> getEmployeesByPagination(Pageable pageable);

    Page<EmployeeEntity> getEmployeesHasTimeSheets(Pageable pageable);

    EmployeeEntity getEmployeeByEMail(String email);
}

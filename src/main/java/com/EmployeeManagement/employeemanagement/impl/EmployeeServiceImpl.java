package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.repository.EmployeeRepository;
import com.EmployeeManagement.employeemanagement.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/*Interface üzerinden implemente edilen methodlar, Repository'de oluşturulan
 methodları döndürecek şekilde çağrılır.*/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final ModelMapper modelMapper;

    //final değişken yalnızca constructor içerisinde değiştirilebilir.
    public EmployeeServiceImpl(EmployeeRepository employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }
    // mapper genel mantığı apı altında tüm entity dönüşünün önüne geçmesi.
    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        // employee objesi Entity altına map edildi. employeeDB değişkeninde tutuldu.
        EmployeeEntity employeeDB = modelMapper.map(employee, EmployeeEntity.class);
        employeeDB = employeeRepo.save(employeeDB); // save işlemi repo altında burada gerçekleşti.
        return modelMapper.map(employeeDB, EmployeeDTO.class); // DTO altına map edilmiş hali geri döndürüldü.
    }

    @Override
    public EmployeeDTO getById(Long id) {
        EmployeeEntity employeeDB = modelMapper.map(id, EmployeeEntity.class);
        employeeDB = employeeRepo.getOne(id);
        return modelMapper.map(employeeDB, EmployeeDTO.class);
    }

    @Override
    public Boolean delete(EmployeeEntity employee) {
        employeeRepo.delete(employee);
        return true;
    }

    @Override
    public EmployeeDTO getByName(EmployeeDTO employee) {
        EmployeeEntity emloyeeDB = modelMapper.map(employee, EmployeeEntity.class);
        emloyeeDB = employeeRepo.getByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
        return modelMapper.map(emloyeeDB, EmployeeDTO.class);
    }
}

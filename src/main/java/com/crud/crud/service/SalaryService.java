package com.crud.crud.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crud.crud.dto.SalaryDTO;
import com.crud.crud.entity.Salary;
import com.crud.crud.entity.User;
import com.crud.crud.mapper.SalaryMapper;
import com.crud.crud.mapper.UserMapper;
import com.crud.crud.repository.SalaryRepository;

@Service
public class SalaryService extends BaseServiceImpl<Salary, SalaryDTO, Long>  {

    private final SalaryRepository salaryRepository;
    private final UserService userService;
    private final SalaryMapper salaryMapper;
    private final UserMapper userMapper;

    // Modify constructor to inject UserMapper
    public SalaryService(SalaryRepository salaryRepository, UserService userService, SalaryMapper salaryMapper, UserMapper userMapper) {
        super(salaryRepository, salaryMapper);
        this.salaryRepository = salaryRepository;
        this.userService = userService;
        this.salaryMapper = salaryMapper;
        this.userMapper = userMapper;
    }

    public List<SalaryDTO> findSalariesByUserId(Long userId) {
        return salaryRepository.findByUserId(userId)
                               .stream()
                               .map(salaryMapper::toDTO)
                               .collect(Collectors.toList());
    }

    public SalaryDTO saveSalaryForUser(Long userId, Salary salary) {
        User user = userService.findById(userId)
                               .orElseThrow(() -> new RuntimeException("User not found"));
        salary.setUser(user);
        Salary savedSalary = salaryRepository.save(salary);
        return salaryMapper.toDTO(savedSalary);
    }

    public SalaryDTO findSalaryByUserId(Long userId, Long id) {
        return salaryRepository.findByIdAndUserId(id, userId)
                               .map(salaryMapper::toDTO)
                               .orElse(null);
    }

    public BigDecimal findNetSalaryByUserId(Long userId, Long id) {
        Salary salary = salaryRepository.findByIdAndUserId(id, userId).orElse(null);
        return salary.getTaxableSalary()
                        .subtract(salary.getAvsAiApgContribution())
                        .subtract(salary.getVdLpcfamDeduction())
                        .subtract(salary.getAcDeduction())
                        .subtract(salary.getAanpDeduction())
                        .subtract(salary.getIjmA1Deduction())
                        .subtract(salary.getLppDeduction());
    }

    public SalaryDTO partialUpdateSalaryForUser(Long userId, Long salaryId, Salary salary) {
        return salaryRepository.findByIdAndUserId(salaryId, userId).map(existingSalary -> {
            if (salary.getTotalSalary() != null) existingSalary.setTotalSalary(salary.getTotalSalary());
            Salary updatedSalary = salaryRepository.save(existingSalary);
            return salaryMapper.toDTO(updatedSalary);
        }).orElse(null);
    }

    public boolean deleteSalaryForUser(Long userId, Long salaryId) {
        return salaryRepository.findByIdAndUserId(salaryId, userId).map(salary -> {
            salaryRepository.delete(salary);
            return true;
        }).orElse(false);
    }
}

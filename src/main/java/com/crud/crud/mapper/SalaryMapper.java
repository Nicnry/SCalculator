package com.crud.crud.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.crud.crud.dto.SalaryDTO;
import com.crud.crud.entity.Salary;

@Component
public class SalaryMapper extends BaseMapper<Salary, SalaryDTO, Long> {
    
    @Override
    public SalaryDTO toDTO(Salary salary) {
        if (salary == null) {
            return null;
        }
        SalaryDTO dto = createDTO();
        dto.setId(salary.getId());
        dto.setTotalSalary(salary.getTotalSalary());
        dto.setTaxableSalary(salary.getTaxableSalary());
        dto.setAvsAiApgContribution(salary.getAvsAiApgContribution());
        dto.setVdLpcfamDeduction(salary.getVdLpcfamDeduction());
        dto.setAcDeduction(salary.getAcDeduction());
        dto.setAanpDeduction(salary.getAanpDeduction());
        dto.setIjmA1Deduction(salary.getIjmA1Deduction());
        dto.setLppDeduction(salary.getLppDeduction());
        return dto;
    }

    @Override
    public Salary toEntity(SalaryDTO salaryDTO) {
        if (salaryDTO == null) {
            return null;
        }

        Salary salary = new Salary();
        salary.setId(salaryDTO.getId());
        return salary;
    }

    @Override
    protected SalaryDTO createDTO() {
        return new SalaryDTO();
    }
}

package com.crud.crud.dto;

import java.math.BigDecimal;

public class SalaryDTO extends BaseDTO<Long> {

    private BigDecimal totalSalary;
    private BigDecimal taxableSalary;
    private BigDecimal avsAiApgContribution;
    private BigDecimal vdLpcfamDeduction;
    private BigDecimal acDeduction;
    private BigDecimal aanpDeduction;
    private BigDecimal ijmA1Deduction;
    private BigDecimal lppDeduction;

    public SalaryDTO() {}

    public SalaryDTO(BigDecimal totalSalary, BigDecimal taxableSalary, BigDecimal avsAiApgContribution, BigDecimal vdLpcfamDeduction, BigDecimal acDeduction, BigDecimal aanpDeduction, BigDecimal ijmA1Deduction, BigDecimal lppDeduction) {
        this.totalSalary = totalSalary;
        this.taxableSalary = taxableSalary;
        this.avsAiApgContribution = avsAiApgContribution;
        this.vdLpcfamDeduction = vdLpcfamDeduction;
        this.acDeduction = acDeduction;
        this.aanpDeduction = aanpDeduction;
        this.ijmA1Deduction = ijmA1Deduction;
        this.lppDeduction = lppDeduction;
    }


    public BigDecimal getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(BigDecimal totalSalary) {
        this.totalSalary = totalSalary;
    }

    public BigDecimal getTaxableSalary() {
        return taxableSalary;
    }

    public void setTaxableSalary(BigDecimal taxableSalary) {
        this.taxableSalary = taxableSalary;
    }

    public BigDecimal getAvsAiApgContribution() {
        return avsAiApgContribution;
    }

    public void setAvsAiApgContribution(BigDecimal avsAiApgContribution) {
        this.avsAiApgContribution = avsAiApgContribution;
    }

    public BigDecimal getVdLpcfamDeduction() {
        return vdLpcfamDeduction;
    }

    public void setVdLpcfamDeduction(BigDecimal vdLpcfamDeduction) {
        this.vdLpcfamDeduction = vdLpcfamDeduction;
    }

    public BigDecimal getAcDeduction() {
        return acDeduction;
    }

    public void setAcDeduction(BigDecimal acDeduction) {
        this.acDeduction = acDeduction;
    }

    public BigDecimal getAanpDeduction() {
        return aanpDeduction;
    }

    public void setAanpDeduction(BigDecimal aanpDeduction) {
        this.aanpDeduction = aanpDeduction;
    }

    public BigDecimal getIjmA1Deduction() {
        return ijmA1Deduction;
    }

    public void setIjmA1Deduction(BigDecimal ijmA1Deduction) {
        this.ijmA1Deduction = ijmA1Deduction;
    }

    public BigDecimal getLppDeduction() {
        return lppDeduction;
    }

    public void setLppDeduction(BigDecimal lppDeduction) {
        this.lppDeduction = lppDeduction;
    }
}

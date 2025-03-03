package com.crud.crud.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "salaries")
public class Salary extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total_salary", nullable = false)
    private BigDecimal totalSalary;

    @Column(name = "taxable_salary", nullable = false)
    private BigDecimal taxableSalary;

    @Column(name = "avs_ai_apg_contribution", nullable = false)
    private BigDecimal avsAiApgContribution;

    @Column(name = "vd_lpcfam_deduction", nullable = false)
    private BigDecimal vdLpcfamDeduction;

    @Column(name = "ac_deduction", nullable = false)
    private BigDecimal acDeduction;

    @Column(name = "aanp_deduction", nullable = false)
    private BigDecimal aanpDeduction;

    @Column(name = "ijm_a1_deduction", nullable = false)
    private BigDecimal ijmA1Deduction;

    @Column(name = "lpp_deduction", nullable = false)
    private BigDecimal lppDeduction;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return taxableSalary
                .multiply(avsAiApgContribution)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public void setAvsAiApgContribution(BigDecimal avsAiApgContribution) {
        this.avsAiApgContribution = avsAiApgContribution;
    }

    public BigDecimal getVdLpcfamDeduction() {
        return taxableSalary
                .multiply(vdLpcfamDeduction)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public void setVdLpcfamDeduction(BigDecimal vdLpcfamDeduction) {
        this.vdLpcfamDeduction = vdLpcfamDeduction;
    }

    public BigDecimal getAcDeduction() {
        return taxableSalary
                .multiply(acDeduction)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public void setAcDeduction(BigDecimal acDeduction) {
        this.acDeduction = acDeduction;
    }

    public BigDecimal getAanpDeduction() {
        return taxableSalary
                .multiply(aanpDeduction)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public void setAanpDeduction(BigDecimal aanpDeduction) {
        this.aanpDeduction = aanpDeduction;
    }

    public BigDecimal getIjmA1Deduction() {
        return taxableSalary
                .multiply(ijmA1Deduction)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
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

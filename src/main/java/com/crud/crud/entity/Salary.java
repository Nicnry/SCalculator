package com.crud.crud.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

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

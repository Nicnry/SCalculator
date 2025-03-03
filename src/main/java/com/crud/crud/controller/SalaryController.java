package com.crud.crud.controller;

import com.crud.crud.dto.SalaryDTO;
import com.crud.crud.entity.Salary;
import com.crud.crud.mapper.SalaryMapper;
import com.crud.crud.service.SalaryService;
import com.crud.crud.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/salaries")
public class SalaryController {

    private final SalaryService salaryService;
    private final UserService userService;
    private final SalaryMapper salaryMapper;

    public SalaryController(SalaryService salaryService, UserService userService, SalaryMapper salaryMapper) {
        this.salaryService = salaryService;
        this.userService = userService;
        this.salaryMapper = salaryMapper;
    }

    @GetMapping
    public ResponseEntity<List<SalaryDTO>> getSalariesByUser(@PathVariable Long userId) {
        List<SalaryDTO> salaries = salaryService.findSalariesByUserId(userId);
        return ResponseEntity.ok(salaries);
    }

    @PostMapping
    public ResponseEntity<SalaryDTO> addSalaryToUser(@PathVariable Long userId, @RequestBody Salary salary) {
        SalaryDTO savedSalary = salaryService.saveSalaryForUser(userId, salary);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalary);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryDTO> getSalaryById(@PathVariable Long userId, @PathVariable Long id) {
        SalaryDTO salary = salaryService.findSalaryByUserId(userId, id);
        return salary != null ? ResponseEntity.ok(salary) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{salaryId}")
    public ResponseEntity<SalaryDTO> partialUpdateSalary(@PathVariable Long userId, @PathVariable Long salaryId, @RequestBody Salary salary) {
        SalaryDTO updatedSalary = salaryService.partialUpdateSalaryForUser(userId, salaryId, salary);
        return updatedSalary != null ? ResponseEntity.ok(updatedSalary) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{salaryId}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long userId, @PathVariable Long salaryId) {
        boolean deleted = salaryService.deleteSalaryForUser(userId, salaryId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/net")
    public ResponseEntity<BigDecimal> getNetSalaryById(@PathVariable Long userId, @PathVariable Long id) {
        BigDecimal salary = salaryService.findNetSalaryByUserId(userId, id);
        return salary != null ? ResponseEntity.ok(salary) : ResponseEntity.notFound().build();
    }
}

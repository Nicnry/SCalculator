package com.crud.crud.repository;

import com.crud.crud.entity.Salary;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends BaseRepository<Salary, Long> {
    List<Salary> findByUserId(Long userId);
    Optional<Salary> findByIdAndUserId(Long id, Long userId);
}

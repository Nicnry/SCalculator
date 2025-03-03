package com.crud.crud.controller;

import com.crud.crud.dto.BankAccountDTO;
import com.crud.crud.entity.BankAccount;
import com.crud.crud.mapper.BankAccountMapper;
import com.crud.crud.service.BankAccountService;
import com.crud.crud.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final UserService userService;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountController(BankAccountService bankAccountService, UserService userService, BankAccountMapper bankAccountMapper) {
        this.bankAccountService = bankAccountService;
        this.userService = userService;
        this.bankAccountMapper = bankAccountMapper;
    }

    @GetMapping
    public ResponseEntity<List<BankAccountDTO>> getSalariesByUser(@PathVariable Long userId) {
        List<BankAccountDTO> bankAccounts = bankAccountService.findBankAccountByUserId(userId);
        return ResponseEntity.ok(bankAccounts);
    }

    @PostMapping
    public ResponseEntity<BankAccountDTO> addBankAccountToUser(@PathVariable Long userId, @RequestBody BankAccount bankAccount) {
        BankAccountDTO savedBankAccount = bankAccountService.saveBankAccountForUser(userId, bankAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBankAccount);
    }

    @GetMapping("/{bankAccountId}")
    public ResponseEntity<BankAccountDTO> getBankAccountById(@PathVariable Long userId, @PathVariable Long bankAccountId) {
        BankAccountDTO bankAccountDTO = bankAccountService.findBankAccountByUserId(userId, bankAccountId);
        return bankAccountDTO != null ? ResponseEntity.ok(bankAccountDTO) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{bankAccountId}")
    public ResponseEntity<BankAccountDTO> partialUpdateBankAccount(@PathVariable Long userId, @PathVariable Long bankAccountId, @RequestBody BankAccount bankAccount) {
        BankAccountDTO updatedBankAccount = bankAccountService.partialUpdateBankAccountForUser(userId, bankAccountId, bankAccount);
        return updatedBankAccount != null ? ResponseEntity.ok(updatedBankAccount) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{bankAccountId}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long userId, @PathVariable Long bankAccountId) {
        boolean deleted = bankAccountService.deleteBankAccountForUser(userId, bankAccountId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

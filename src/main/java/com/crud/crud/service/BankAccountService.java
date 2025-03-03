package com.crud.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crud.crud.dto.BankAccountDTO;
import com.crud.crud.entity.BankAccount;
import com.crud.crud.entity.User;
import com.crud.crud.mapper.BankAccountMapper;
import com.crud.crud.mapper.UserMapper;
import com.crud.crud.repository.BankAccountRepository;

@Service
public class BankAccountService extends BaseServiceImpl<BankAccount, BankAccountDTO, Long>  {

    private final BankAccountRepository bankAccountRepository;
    private final UserService userService;
    private final BankAccountMapper bankAccountMapper;
    private final UserMapper userMapper;

    // Modify constructor to inject UserMapper
    public BankAccountService(BankAccountRepository bankAccountRepository, UserService userService, BankAccountMapper bankAccountMapper, UserMapper userMapper) {
        super(bankAccountRepository, bankAccountMapper);
        this.bankAccountRepository = bankAccountRepository;
        this.userService = userService;
        this.bankAccountMapper = bankAccountMapper;
        this.userMapper = userMapper;
    }

    public List<BankAccountDTO> findBankAccountByUserId(Long userId) {
        return bankAccountRepository.findByUserId(userId)
                               .stream()
                               .map(bankAccountMapper::toDTO)
                               .collect(Collectors.toList());
    }

    public BankAccountDTO saveBankAccountForUser(Long userId, BankAccount bankAccount) {
        // Use userMapper here
        User user = userService.findById(userId)
                               .orElseThrow(() -> new RuntimeException("User not found"));
        bankAccount.setUser(user);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDTO(savedBankAccount);
    }

    public BankAccountDTO findBankAccountByUserId(Long userId, Long bankAccountId) {
        return bankAccountRepository.findByIdAndUserId(bankAccountId, userId)
                               .map(bankAccountMapper::toDTO)
                               .orElse(null);
    }

    public BankAccountDTO partialUpdateBankAccountForUser(Long userId, Long bankAccountId, BankAccount bankAccount) {
        return bankAccountRepository.findByIdAndUserId(bankAccountId, userId).map(existingBankAccount -> {
            if (bankAccount.getBankName() != null) existingBankAccount.setBankName(bankAccount.getBankName());
            BankAccount updatedBankAccount = bankAccountRepository.save(existingBankAccount);
            return bankAccountMapper.toDTO(updatedBankAccount);
        }).orElse(null);
    }

    public boolean deleteBankAccountForUser(Long userId, Long bankAccountId) {
        return bankAccountRepository.findByIdAndUserId(bankAccountId, userId).map(bankAccount -> {
            bankAccountRepository.delete(bankAccount);
            return true;
        }).orElse(false);
    }
}

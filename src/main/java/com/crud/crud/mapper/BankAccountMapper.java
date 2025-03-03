package com.crud.crud.mapper;

import org.springframework.stereotype.Component;

import com.crud.crud.dto.BankAccountDTO;
import com.crud.crud.entity.BankAccount;

@Component
public class BankAccountMapper extends BaseMapper<BankAccount, BankAccountDTO, Long> {
    
    @Override
    public BankAccountDTO toDTO(BankAccount bankAccount) {
        if (bankAccount == null) {
            return null;
        }
        BankAccountDTO dto = createDTO();
        dto.setId(bankAccount.getId());
        dto.setAccountType(bankAccount.getAccountType());
        dto.setBankName(bankAccount.getBankName());
        dto.setAccountNumber(bankAccount.getAccountNumber());
        dto.setBalance(bankAccount.getBalance());
        dto.setCurrency(bankAccount.getCurrency());
        dto.setCreatedAt(bankAccount.getCreatedAt());
        dto.setUpdatedAt(bankAccount.getUpdatedAt());
        dto.setDeletedAt(bankAccount.getDeletedAt());
        return dto;
    }

    @Override
    public BankAccount toEntity(BankAccountDTO bankAccountDTO) {
        if (bankAccountDTO == null) {
            return null;
        }

        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(bankAccountDTO.getId());
        return bankAccount;
    }

    @Override
    protected BankAccountDTO createDTO() {
        return new BankAccountDTO();
    }
}

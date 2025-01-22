package com.rbravo.ms_account.mapper;

import com.rbravo.ms_account.model.dto.AccountDTO;
import com.rbravo.ms_account.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Represent mapper dto to account
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountDTO accountDTO);

    AccountDTO toDTO(Account account);
}

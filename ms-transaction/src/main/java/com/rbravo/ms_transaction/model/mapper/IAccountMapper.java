package com.rbravo.ms_transaction.model.mapper;


import com.rbravo.ms_transaction.model.dto.AccountDTO;
import com.rbravo.ms_transaction.model.entity.Account;
import org.mapstruct.Mapper;

/**
 * Represent mapper dto to accoun
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface IAccountMapper extends IGenericMapper<Account, AccountDTO> {
}

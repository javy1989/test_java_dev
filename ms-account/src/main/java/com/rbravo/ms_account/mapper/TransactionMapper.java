package com.rbravo.ms_account.mapper;

import com.rbravo.ms_account.model.dto.TransactionDTO;
import com.rbravo.ms_account.model.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Represent mapper dto to transaction
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toEntity(Transaction transaction);

    TransactionDTO toDTO(Transaction transaction);
}

package com.rbravo.ms_management.model.mapper;

import com.rbravo.ms_management.model.dto.PersonDTO;
import com.rbravo.ms_management.model.entity.Person;
import org.mapstruct.Mapper;

/**
 * Represent mapper DTO to person
 *
 * @author rbravo
 */
@Mapper(componentModel = "spring")
public interface IPersonMapper extends IGenericMapper<Person, PersonDTO> {
}

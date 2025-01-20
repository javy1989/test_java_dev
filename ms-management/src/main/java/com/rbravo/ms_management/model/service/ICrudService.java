package com.rbravo.ms_management.model.service;

import java.util.List;

/**
 * Represent crud basic
 *
 * @param <DTO> the DTO
 * @param <ID>  the ID
 * @author rbravo
 */
public interface ICrudService<DTO, ID> {

    /**
     * Save dto
     *
     * @param dto the DTO
     * @return to DTO
     */
    DTO save(DTO dto);

    /**
     * Search by id
     *
     * @param id the id search
     * @return to DTO
     */
    DTO findByid(ID id);

    /**
     * Get list
     *
     * @return to {@link List<DTO>}
     */
    List<DTO> findAll();


    /**
     * Delete DTO
     *
     * @param id the id
     */
    void delete(ID id);
}

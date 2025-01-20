package com.rbravo.ms_management.model.service.impl;

import com.rbravo.ms_management.model.mapper.IGenericMapper;
import com.rbravo.ms_management.model.repository.IGenericRepository;
import com.rbravo.ms_management.model.service.ICrudService;

import java.util.List;

/**
 * Operation basic in crud
 *
 * @param <Entity> the entity
 * @param <DTO>    the data transfer object
 * @param <ID>     the id entity
 */
public abstract class CrudService<Entity, DTO, ID> implements ICrudService<DTO, ID> {

    protected abstract IGenericRepository<Entity, ID> getRepo();

    protected abstract IGenericMapper<Entity, DTO> getMapper();


    @Override
    public DTO save(DTO dto) {
        Entity entity = getMapper().toEntity(dto);
        Entity savedEntity = getRepo().save(entity);
        return getMapper().toDTO(savedEntity);
    }

    @Override
    public DTO findByid(ID id) {
        return getRepo().findById(id).map(getMapper()::toDTO)
                .orElseThrow(() -> new IllegalStateException("Entity not found with ID: " + id));
    }

    @Override
    public List<DTO> findAll() {
        return getRepo().findAll().stream().map(getMapper()::toDTO).toList();
    }

    @Override
    public void delete(ID id) {
        findByid(id);
        getRepo().deleteById(id);
    }
}

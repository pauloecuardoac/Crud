package com.br.business.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.business.dto.ConsultaDTO;
import com.br.business.entities.Consulta;
import com.br.business.repositories.ConsultaRepository;
import com.br.business.services.exceptions.DatabaseException;
import com.br.business.services.exceptions.ResourceNotFoundException;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ConsultaDTO> findAllPaged(PageRequest pageRequest){
		Page<Consulta> list = repository.findAll(pageRequest);
		return list.map(x -> new ConsultaDTO(x));
	}

	@Transactional(readOnly = true)
	public ConsultaDTO findById(Long id) {
		Optional <Consulta> obj = repository.findById(id);
		Consulta entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ConsultaDTO(entity);
	}

	@Transactional
	public ConsultaDTO insert(ConsultaDTO dto) {
		Consulta entity = new Consulta();
		entity.setNome(dto.getNome());
		entity.setCnpj(dto.getCnpj());
		entity.setEmail(dto.getEmail());
		entity.setEmpresa(dto.getEmpresa());
		
		entity = repository.save(entity);
		return new ConsultaDTO(entity);
	}

	@Transactional
	public ConsultaDTO update(Long id, ConsultaDTO dto) {
		try {
			Consulta entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setCnpj(dto.getCnpj());
			entity.setEmail(dto.getEmail());
			entity.setEmpresa(dto.getEmpresa());
			return new ConsultaDTO(entity);
		}
		catch(EntityNotFoundException e ) {
			throw new ResourceNotFoundException("Id not found "+id);
		}		
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation"); 
		}
		
	}

}

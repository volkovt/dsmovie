package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly=true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(MovieDTO::new);
	}

	@Transactional(readOnly=true)
	public MovieDTO findById(Long id) {
		return repository.findById(id).map(MovieDTO::new).get();
	}
}

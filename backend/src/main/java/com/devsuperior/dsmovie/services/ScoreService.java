package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.*;
import com.devsuperior.dsmovie.entities.*;
import com.devsuperior.dsmovie.repositories.*;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = repository.saveAndFlush(score);
		
		double sum = movie.getScores().stream().mapToDouble(x -> x.getValue()).sum();
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}

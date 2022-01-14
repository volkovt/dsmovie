package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmovie.dto.*;
import com.devsuperior.dsmovie.services.ScoreService;

@RestController
@RequestMapping("scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PutMapping(value="/{id}")
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		return service.saveScore(dto);
	}
}

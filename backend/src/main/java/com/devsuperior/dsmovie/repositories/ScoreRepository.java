package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsmovie.entities.*;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}

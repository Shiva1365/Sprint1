package com.edusystem.service;

import java.util.List;

import com.edusystem.entity.Trainer;

public interface TrainerService {

	public Trainer saveTrainer(Trainer trainer);

	public Trainer getTrainerById(int trainerId);

	public List<Trainer> getAllTrainers();

	public Trainer updateTrainer(Trainer trainer);

	public void deleteTrainer(int trainerId);

}
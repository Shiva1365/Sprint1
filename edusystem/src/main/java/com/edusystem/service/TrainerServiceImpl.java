package com.edusystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.Trainer;
import com.edusystem.exception.TrainerNotFoundException;
import com.edusystem.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;

	@Override
	public Trainer saveTrainer(Trainer trainer) {
		Trainer newTrainer = trainerRepository.save(trainer);
		return trainer;
	}

	@Override
	public Trainer getTrainerById(int trainerId) {

		Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);

		if (optionalTrainer.isEmpty()) {
			throw new TrainerNotFoundException("Trainer Not existing with id: " + trainerId);
		}

		Trainer trainer = optionalTrainer.get();

		return trainer;
	}

	@Override
	public List<Trainer> getAllTrainers() {

		List<Trainer> trainer = trainerRepository.findAll();

		return trainer;
	}

	@Override
	public Trainer updateTrainer(Trainer trainer) {
		Optional<Trainer> optionalTrainer = trainerRepository.findById(trainer.getTrainerId());

		if (optionalTrainer.isEmpty()) {
			throw new TrainerNotFoundException("Trainer Not found with id: " + trainer.getTrainerId());
		}

		Trainer updatedTrainer = trainerRepository.save(trainer);

		return updatedTrainer;
	}

	@Override
	public void deleteTrainer(int trainerId) {
		Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
		if (optionalTrainer.isEmpty()) {
			throw new TrainerNotFoundException("Trainer Not found with id: " + trainerId);
		}

		trainerRepository.deleteById(trainerId);
	}

}
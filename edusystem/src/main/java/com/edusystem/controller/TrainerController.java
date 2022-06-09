package com.edusystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edusystem.entity.Trainer;
import com.edusystem.service.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	private TrainerService trainerService;

	@PostMapping("/trainer/save")
	public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {

		Trainer newTrainer = trainerService.saveTrainer(trainer);
		ResponseEntity<Trainer> responseEntity = new ResponseEntity<>(newTrainer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> fetchTrainerDetails(@PathVariable("trainerId") int trainerId) {

		Trainer trainer = trainerService.getTrainerById(trainerId);
		ResponseEntity<Trainer> responseEntity = new ResponseEntity<>(trainer, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/trainer/all")
	public List<Trainer> fetchAllTrainer() {

		List<Trainer> trainerList = trainerService.getAllTrainers();
		return trainerList;
	}

	@PutMapping("/trainer/update")
	public ResponseEntity<Trainer> modifyProduct(@RequestBody Trainer trainer) {

		Trainer updatedTrainer = trainerService.updateTrainer(trainer);
		ResponseEntity<Trainer> responseEntity = new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/trainer/delete/{trainerId}")
	public ResponseEntity<String> removeProduct(@PathVariable("trainerId") int trainerId) {

		trainerService.deleteTrainer(trainerId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Trainer Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

}
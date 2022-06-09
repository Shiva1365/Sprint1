package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edusystem.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}

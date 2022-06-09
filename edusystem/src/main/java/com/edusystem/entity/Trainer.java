package com.edusystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainer_table")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trainer_id")
	private int trainerId;

	@Column(name = "trainer_name")
	private String trainerName;

	@Column(name = "trainer_email", unique = true, nullable = false)
	private String trainerEmail;

	@Column(name = "trainer_mobile", unique = true, nullable = false)
	private int trainerMobile;

	@Column(name = "trainer_experience")
	private double trainerExperience;

	@Column(name = "trainer_skillset")
	private String trainerSkillset;

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public int getTrainerMobile() {
		return trainerMobile;
	}

	public void setTrainerMobile(int trainerMobile) {
		this.trainerMobile = trainerMobile;
	}

	public double getTrainerExperience() {
		return trainerExperience;
	}

	public void setTrainerExperience(double trainerExperience) {
		this.trainerExperience = trainerExperience;
	}

	public String getTrainerSkillset() {
		return trainerSkillset;
	}

	public void setTrainerSkillset(String trainerSkillset) {
		this.trainerSkillset = trainerSkillset;
	}

}
package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edusystem.entity.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.userId = :uid and u.userPassword = :upwd")
	User login(@Param("uid") int userId, @Param("upwd") String userPassword);

}

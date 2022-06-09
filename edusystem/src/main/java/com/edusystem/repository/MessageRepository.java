package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edusystem.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}

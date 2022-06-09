package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edusystem.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}

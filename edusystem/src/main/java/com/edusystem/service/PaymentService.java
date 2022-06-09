package com.edusystem.service;

import java.util.List;

import com.edusystem.entity.Payment;

public interface PaymentService {

	public Payment savePayment(Payment payment,int studentId);

	public Payment getPaymentById(int payment);

	public List<Payment> getAllPayment();

	public Payment updatePayment(Payment payment);

	public void deletePayment(int paymentId);
}
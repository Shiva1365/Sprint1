package com.edusystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.Payment;
import com.edusystem.entity.StudentDetails;
import com.edusystem.exception.PaymentNotFoundException;
import com.edusystem.exception.StudentNotFoundException;
import com.edusystem.repository.PaymentRepository;
import com.edusystem.repository.StudentDetailsRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	StudentDetailsRepository studentDetailsRepository;

	@Override
	public Payment savePayment(Payment payment, int studentId) {

		payment.setDate(LocalDate.now());
		Optional<StudentDetails> optionalStudentDetails = studentDetailsRepository.findById(studentId);

		if (optionalStudentDetails.isEmpty()) {
			throw new StudentNotFoundException("Student Not existing with id: " + studentId);
		}

		StudentDetails studentDetails = optionalStudentDetails.get();
		payment.setStudentDetails(studentDetails);

		Payment newPayment = paymentRepository.save(payment);
		return newPayment;
	}

	@Override
	public Payment getPaymentById(int paymentId) {

		Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);

		if (optionalPayment.isEmpty()) {
			throw new PaymentNotFoundException("Payment Not existing with id: " + paymentId);
		}

		Payment payment = optionalPayment.get();

		return payment;

	}

	@Override
	public List<Payment> getAllPayment() {
		List<Payment> payment = paymentRepository.findAll();

		return payment;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		Optional<Payment> optionalPayment = paymentRepository.findById(payment.getPaymentId());

		if (optionalPayment.isEmpty()) {
			throw new PaymentNotFoundException("Payment Not found with id: " + payment.getPaymentId());
		}

		Payment payment1 = optionalPayment.get();
		StudentDetails studentDetails = payment1.getStudentDetails();
		payment.setStudentDetails(studentDetails);

		Payment updatedPayment = paymentRepository.save(payment);

		return updatedPayment;

	}

	@Override
	public void deletePayment(int paymentId) {

		Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
		if (optionalPayment.isEmpty()) {
			throw new PaymentNotFoundException("Payment Not found with id: " + paymentId);
		}

		paymentRepository.deleteById(paymentId);
	}

}
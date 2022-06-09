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

import com.edusystem.entity.Payment;
import com.edusystem.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payment/save/{studentId}")
	public ResponseEntity<Payment> addPayment(@PathVariable int studentId,@RequestBody Payment payment) {

		Payment newPayment = paymentService.savePayment(payment,studentId);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(newPayment, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/payment/{paymentId}")
	public ResponseEntity<Payment> fetchPaymentDetails(@PathVariable("paymentId") int paymentId) {

		Payment payment = paymentService.getPaymentById(paymentId);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(payment, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/payment/all")
	public List<Payment> fetchAllPayment() {

		List<Payment> paymentList = paymentService.getAllPayment();
		return paymentList;
	}

	@PutMapping("/payment/update")
	public ResponseEntity<Payment> modifyProduct(@RequestBody Payment payment) {

		Payment updatedPayment = paymentService.updatePayment(payment);
		ResponseEntity<Payment> responseEntity = new ResponseEntity<>(updatedPayment, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/payment/delete/{paymentId}")
	public ResponseEntity<String> removeProduct(@PathVariable("paymentId") int paymentId) {

		paymentService.deletePayment(paymentId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Payment Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

}
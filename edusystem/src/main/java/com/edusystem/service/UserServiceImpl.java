package com.edusystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.User;
import com.edusystem.exception.AuthenticationFailedException;
import com.edusystem.exception.UserNotFoundException;
import com.edusystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		return user;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with id: " + userId);
		}

		User user = optionalUser.get();

		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> user = userRepository.findAll();

		return user;

	}

	@Override
	public User updateUser(User user) {
		Optional<User> optionalUser = userRepository.findById(user.getUserId());

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not found with id: " + user.getUserId());
		}

		User updatedUser = userRepository.save(user);

		return updatedUser;
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not found with id: " + userId);
		}

		userRepository.deleteById(userId);

	}

	@Override
	public User doLogin(int userId, String userPassword) {
		User user = userRepository.login(userId, userPassword);
		if (user == null) {
			throw new AuthenticationFailedException("UserId or Password Invalid");
		}

		return user;

	}

}

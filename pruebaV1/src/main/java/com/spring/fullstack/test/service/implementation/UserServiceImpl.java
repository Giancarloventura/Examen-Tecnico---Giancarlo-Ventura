package com.spring.fullstack.test.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fullstack.test.dao.UserRepository;
import com.spring.fullstack.test.entity.User;
import com.spring.fullstack.test.exception.GeneralException;
import com.spring.fullstack.test.exception.InvalidElementException;
import com.spring.fullstack.test.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String create(User user) throws GeneralException {
		log.debug("UserServiceImpl - create - start");
		try {
			userRepository.save(user);
			return "User successfully created";
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralException("Could'nt create the user");
		}
	}

	@Override
	public List<User> read() throws GeneralException {
		log.debug("UserServiceImpl - read - start");
		List<User> userList = new ArrayList<>(); 
		try {
			userList = userRepository.findAll();
			return userList;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralException("Could'nt read the users");
		} 
	}
	@Override
	public String update(User user) throws GeneralException {
		log.debug("UserServiceImpl - update - start");
		try {
			Optional<User> userNonEdited = userRepository.findById(user.getIdUser());
			userRepository.save(getValues(userNonEdited.orElseThrow(InvalidElementException::new), user));
			return "User successfully updated";
		}catch (InvalidElementException e) {
			log.error(e.getMessage());
			throw new GeneralException("Can't find the user");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralException("Could'nt update the user");
		}
	}

	@Override
	public String delete(Long id) throws GeneralException {
		log.debug("UserServiceImpl - delete - start");
		try {
			Optional<User> user = userRepository.findById(id);
			userRepository.delete(user.orElseThrow(InvalidElementException::new));
			return "User successfully deleted";
		}catch (InvalidElementException e) {
			log.error(e.getMessage());
			throw new GeneralException("Can't find the user");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralException("Could'nt delete the user");
		}
	}
	
	private User getValues(User user, User edited) {
		user.setTxAvatar(edited.getTxAvatar()!=null?edited.getTxAvatar():null);
		user.setTxFullName(edited.getTxFullName()!=null?edited.getTxFullName():null);
		user.setTxUser(edited.getTxUser());
		user.setTxUID(edited.getTxUID());
		user.setTxRol(edited.getTxRol());
		user.setTxPass(edited.getTxPass());
		user.setTxEmail(edited.getTxEmail());
		return user;
	}
}

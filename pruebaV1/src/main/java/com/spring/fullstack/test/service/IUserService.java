package com.spring.fullstack.test.service;

import java.util.List;

import com.spring.fullstack.test.entity.User;
import com.spring.fullstack.test.exception.GeneralException;

public interface IUserService {
	public String create(User user) throws GeneralException;
	public List<User> read() throws GeneralException;
	public String update(User user) throws GeneralException;
	public String delete(Long id) throws GeneralException;
}

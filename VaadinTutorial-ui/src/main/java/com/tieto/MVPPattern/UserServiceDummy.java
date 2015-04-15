package com.tieto.MVPPattern;

import com.vaadin.server.ServiceException;

public class UserServiceDummy implements UserService {
	
	@Override
	public User login(User user) throws ServiceException {
		return user;
	}

}

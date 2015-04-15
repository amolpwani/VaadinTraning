package com.tieto.MVPPattern;

import com.vaadin.server.ServiceException;

public interface UserService {
	User login(User user) throws	ServiceException;
}

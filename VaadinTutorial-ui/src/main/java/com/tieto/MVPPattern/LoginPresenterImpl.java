package com.tieto.MVPPattern;

import com.vaadin.navigator.View;
import com.vaadin.server.ServiceException;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

public class LoginPresenterImpl implements LoginPresenter {

	private LoginView view;
	private UserService service;
	private User user;
	
	public LoginPresenterImpl(LoginView view) {
		this.view = view;
		service = new UserServiceDummy();
		
		view.init();
		
		view.getBtnLogin().addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				login();
			}
		});
	}

	@Override
	public void login() {
		TextField txtUsername = view.getTxtUsername();
		TextField txtPassword = view.getTxtPassword();
		String username = txtUsername.getValue();
		String password = txtPassword.getValue();
		user = new User(username, password);
		try {
			service.login(user);
			view.afterSuccessfulLogin();
		} catch (ServiceException e) {
			// TODO: log exception
			// TODO: notify view about failure
		}
		
	}

	public View getView() {
		return view;
	}

}

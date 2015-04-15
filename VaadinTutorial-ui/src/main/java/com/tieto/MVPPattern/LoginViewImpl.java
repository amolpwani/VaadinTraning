package com.tieto.MVPPattern;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginViewImpl extends VerticalLayout implements LoginView {

	private TextField txtUsername;
	private TextField txtPassword;
	private Button btnLogin;
	
	@Override
	public void init() {
		txtUsername = new TextField("Username:");
		addComponent(txtUsername);
		
		txtPassword = new TextField("Password:");
		addComponent(txtPassword);
		
		btnLogin = new Button("Login");
		addComponent(btnLogin);
	}
	
	@Override
	public TextField getTxtUsername() {
		return txtUsername;
	}
	
	@Override
	public TextField getTxtPassword() {
		return txtPassword;
	}
	
	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		//Do something before view is shown on the screen.
	}
	
	@Override
	public Button getBtnLogin() {
		return btnLogin;
	}
	
	@Override
	public void afterSuccessfulLogin() {
		UI.getCurrent().getNavigator().navigateTo("simplecomponents");
	}
}
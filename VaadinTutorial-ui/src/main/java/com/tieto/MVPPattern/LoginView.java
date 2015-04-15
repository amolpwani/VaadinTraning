package com.tieto.MVPPattern;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

/**
 * Defines all the needed methods for the view layer. 
 * The presenter will communicate with the view layer via this interface.
 */
public interface LoginView extends View{
	void init();
	TextField getTxtUsername();
	TextField getTxtPassword();
	Button getBtnLogin();
	void afterSuccessfulLogin();
}

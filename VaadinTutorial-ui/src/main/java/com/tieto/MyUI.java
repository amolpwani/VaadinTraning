package com.tieto;

import javax.servlet.annotation.WebServlet;

import com.tieto.MVPPattern.LoginPresenterImpl;
import com.tieto.MVPPattern.LoginView;
import com.tieto.MVPPattern.LoginViewImpl;
import com.tieto.MVPPattern.UserServiceDummy;
import com.tieto.SimpleComponents.PanelView;
import com.tieto.SimpleComponents.SimpleComponentView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("com.tieto.MyAppWidgetset")
public class MyUI extends UI {
    
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
	
    Navigator navigator;
    protected static final String SIMPLE_COMPONENTS = "simplecomponents";
    protected static final String PANEL = "panel";
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	getPage().setTitle("Vaadin Tutorial");
    	
    	navigator = new Navigator(this, this);
    	navigator.addView("", new StartView());
    	navigator.addView(SIMPLE_COMPONENTS, new SimpleComponentView());
    	navigator.addView(PANEL, new PanelView());
    	navigator.addView("MVP", new LoginViewImpl());
    	
    	LoginView loginView = new LoginViewImpl();
    	navigator.addView("Login_View", new LoginPresenterImpl(loginView).getView());
    }

    /**
     * A start view for navigating to the other views.
     */
    public class StartView extends VerticalLayout implements View {

    	@Override
    	public void enter(ViewChangeEvent event) {
    	}

    	public StartView() {
    		setSpacing(true);
    		
    		HorizontalLayout horizontalLayout = new HorizontalLayout();
    		horizontalLayout.setSizeFull();
    		Label label = new Label("Vaadin Tutorial");
    		label.setStyleName(ValoTheme.LABEL_BOLD);
    		label.addStyleName(ValoTheme.LABEL_H1);
    		horizontalLayout.addComponent(label);
    		horizontalLayout.setComponentAlignment(label, Alignment.TOP_CENTER);
    		addComponent(horizontalLayout);
    		
    		Button button = new Button("Simple Components", 
    				new Button.ClickListener() {
		                @Override
		                public void buttonClick(ClickEvent event) {
		                	
		                    navigator.navigateTo(SIMPLE_COMPONENTS);
		                }
            		});
    		button.setStyleName(ValoTheme.BUTTON_LINK);
            addComponent(button);
            
            button = new Button("Panel", 
    				new Button.ClickListener() {
		                @Override
		                public void buttonClick(ClickEvent event) {
		                	
		                    navigator.navigateTo(PANEL);
		                }
            		});
    		button.setStyleName(ValoTheme.BUTTON_LINK);
    		addComponent(button);
    		
    		//MVP Pattern
            button = new Button("MVP", 
    				new Button.ClickListener() {
		                @Override
		                public void buttonClick(ClickEvent event) {
		                	
		                    navigator.navigateTo("Login_View");
		                }
            		});
    		button.setStyleName(ValoTheme.BUTTON_LINK);
    		addComponent(button);
    		
    	}
    }
    
}

package com.tieto.SimpleComponents;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Panel is a single-component container with a frame around the content. 
 * It has an optional caption and an icon which are handled by the panel itself, not its containing layout. 
 * The panel itself does not manage the caption of its contained component. You need to set the content with setContent().
 * 
 *
 */
public class PanelView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Panel", Type.TRAY_NOTIFICATION);
	}
	
	public PanelView() {
		addComponent(createPanelWithCssLayout());
		createPanelWithCustomLayout();
	}
	
	private CssLayout createPanelWithCssLayout() {
		CssLayout cssLayout = new CssLayout();
		cssLayout.addComponent(createSimplePanel());
		cssLayout.addComponent(createHorizontalSplitPanel());
		cssLayout.addComponent(createVerticleSplitPanel());
		return cssLayout;
	}
	
	private Panel createSimplePanel(){
		Panel panel = new Panel("Simple Panel");
		panel.setContent(new Label("This is simple panel"));
		panel.setHeight("300px");
		panel.setWidth("300px");
		panel.setPrimaryStyleName("v-panel-orange");
		return panel;
	}
	
	/**
	 * HorizontalSplitPanel makes the split horizontally.
	 * @return
	 */
	private HorizontalSplitPanel createHorizontalSplitPanel() {
		HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		horizontalSplitPanel.setFirstComponent(new Label("75% wide panel"));
		horizontalSplitPanel.setSecondComponent(new Label("25% wide panel"));
		
		// Set the position of the splitter as percentage
		horizontalSplitPanel.setSplitPosition(75, Sizeable.Unit.PIXELS);
		horizontalSplitPanel.setHeight("300px");
		horizontalSplitPanel.setWidth("300px");
		horizontalSplitPanel.setStyleName(ValoTheme.PROBRESSBAR_POINT);
		return horizontalSplitPanel;
	}

	/**
	 * HorizontalSplitPanel makes the split horizontally.
	 * @return
	 */
	private VerticalSplitPanel createVerticleSplitPanel() {
		VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
		verticalSplitPanel.setFirstComponent(new Label("75% wide panel"));
		verticalSplitPanel.setSecondComponent(new Label("25% wide panel"));
		
		// Set the position of the splitter as percentage
		verticalSplitPanel.setSplitPosition(75, Sizeable.Unit.PIXELS);
		verticalSplitPanel.setHeight("300px");
		verticalSplitPanel.setWidth("300px");
		verticalSplitPanel.setPrimaryStyleName("v-panel-green");
		return verticalSplitPanel;
	}
	
	
	private void createPanelWithCustomLayout() {
		// Have a Panel where to put the custom layout.
		Panel panel = new Panel("Login");
		panel.setSizeUndefined();
		addComponent(panel);


		// Create custom layout from "layoutname.html" template.
		CustomLayout custom = new CustomLayout("mylayout");
		custom.setPrimaryStyleName("anchorContainer");


		// Use it as the layout of the Panel.
		panel.setContent(custom);


		// Create a few components and bind them to the location tags
		// in the custom layout.
		TextField username = new TextField();
		custom.addComponent(username, "username");


		TextField password = new TextField();
		custom.addComponent(password, "password");


		Button ok = new Button("Login");
		custom.addComponent(ok, "okbutton");
	}
	
	
}

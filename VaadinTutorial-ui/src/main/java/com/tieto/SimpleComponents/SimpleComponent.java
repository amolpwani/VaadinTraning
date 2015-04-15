/**
 * 
 */
package com.tieto.SimpleComponents;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This class will have simple components like button, label.
 * @author survesac
 *
 */
public class SimpleComponent extends CustomComponent {

	private VerticalLayout verticalLayout;
	
	public SimpleComponent() {
		verticalLayout = new VerticalLayout();
		setCompositionRoot(verticalLayout);
		verticalLayout.addComponent(createlabel());
		verticalLayout.setSpacing(true);
		verticalLayout.addComponent(createButton());
		verticalLayout.addComponent(createHorizontalLayout());
		verticalLayout.addComponent(createGridLayout());
	}
	
	/**
	 * Label component displays non-editable text. 
	 * This text can be used for short simple labels or for displaying long text, such as paragraphs. 
	 * The text can be formatted in HTML or as preformatted text, depending on the content mode of the label.
	 * @return
	 */
	private Label createlabel() {
		Label sample = new Label(
                "This is an example of a"
                        + "\n"
                        + "\n<a href='https://vaadin.com/api/com/vaadin/ui/Label.html'>"
                        + "Label</a> \ncomponent.");
        sample.setContentMode(ContentMode.HTML);
        sample.setStyleName(ValoTheme.LABEL_SUCCESS);
        sample.setWidthUndefined();
        return sample;
		
	}
	
	/**
	 * This will add button to UI.
	 * Also it will handle button click.
	 * @return
	 */
	private Button createButton() {
        Button button = new Button("Click Me");
        button.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            	Label label = new Label("Thank you for clicking");
            	label.setStyleName(ValoTheme.LABEL_COLORED);
            	verticalLayout.addComponent(label);
            }
        });
        return button;
	}
	
	/**
	 * Create Horizontal Layout with caption.
	 * @return
	 */
	private HorizontalLayout createHorizontalLayout() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setCaption("Horizontal Layout");
		horizontalLayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		horizontalLayout.setSpacing(true);
		
		Label label1 = new Label("Label 1");
		label1.setStyleName(ValoTheme.LABEL_BOLD);
		horizontalLayout.addComponent(label1);
		
		label1 = new Label("Label 2");
		label1.setStyleName(ValoTheme.LABEL_COLORED);
		horizontalLayout.addComponent(label1);

		label1 = new Label("Label 3");
		label1.setStyleName(ValoTheme.LABEL_FAILURE);
		horizontalLayout.addComponent(label1);

		label1 = new Label("Label 4");
		label1.setStyleName(ValoTheme.LABEL_HUGE);
		horizontalLayout.addComponent(label1);

		label1 = new Label("Label 5");
		label1.setStyleName(ValoTheme.LABEL_LARGE);
		horizontalLayout.addComponent(label1);

		label1 = new Label("Label 6");
		label1.setStyleName(ValoTheme.LABEL_LIGHT);
		horizontalLayout.addComponent(label1);

		label1 = new Label("Label 7");
		label1.setStyleName(ValoTheme.LABEL_SPINNER);
		horizontalLayout.addComponent(label1);

		label1 = new Label("Label 8");
		label1.setStyleName(ValoTheme.LABEL_TINY);
		horizontalLayout.addComponent(label1);
		
		return horizontalLayout;
	}
	
	
	/**
	 * Create Grid Layout with caption.
	 * @return
	 */
	private GridLayout createGridLayout() {
		GridLayout gridLayout = new GridLayout(3, 3);
		gridLayout.setSizeFull();;
		
		gridLayout.setCaption("Grid Layout");
		gridLayout.setStyleName(ValoTheme.LAYOUT_CARD);
		gridLayout.setSpacing(true);
		
		Label label1 = new Label("Label 1");
		label1.setStyleName(ValoTheme.LABEL_H1);
		gridLayout.addComponent(label1);
		
		label1 = new Label("Label 2");
		label1.setStyleName(ValoTheme.LABEL_H2);
		gridLayout.addComponent(label1);

		label1 = new Label("Label 3");
		label1.setStyleName(ValoTheme.LABEL_SMALL);
		gridLayout.addComponent(label1);

		Button button1 = new Button("Button 1");
		button1.setStyleName(ValoTheme.BUTTON_PRIMARY);
		gridLayout.addComponent(button1);

		button1 = new Button("Button 2");
		button1.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
		gridLayout.addComponent(button1);

		button1 = new Button("Button 3");
		button1.setStyleName(ValoTheme.BUTTON_DANGER);
		gridLayout.addComponent(button1);

		button1 = new Button("Button 4");
		button1.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		gridLayout.addComponent(button1);

		button1 = new Button("Button 5");
		button1.setStyleName(ValoTheme.BUTTON_LINK);
		gridLayout.addComponent(button1);
		
		button1 = new Button("Button 6");
		button1.setStyleName(ValoTheme.BUTTON_TINY);
		gridLayout.addComponent(button1);
		
		return gridLayout;
	}
}

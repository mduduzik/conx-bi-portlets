package com.conx.bi.portal.login.ui.view;

import org.pakhama.vaadin.mvp.event.EventScope;
import org.pakhama.vaadin.mvp.view.impl.View;

import com.conx.bi.portal.login.ui.event.LoginFieldChangedEvent;
import com.conx.bi.portal.login.ui.event.LoginSubmittedEvent;
import com.conx.bi.portal.login.ui.view.component.LoginButton;
import com.conx.bi.portal.login.ui.view.field.LoginFieldLabel;
import com.conx.bi.portal.login.ui.view.field.LoginPasswordField;
import com.conx.bi.portal.login.ui.view.field.LoginTextField;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends View implements ILoginView, TextChangeListener {
	private static final long serialVersionUID = -212578951543188340L;

	private static final String FORM_LAYOUT_WIDTH = "480px";
	private static final String VIEW_WIDTH = "700px";
	private static final String VIEW_HEIGHT = "100%";
	private static final String CUSTOM_TITLE_LAYOUT_STYLE = "registration-title-layout";
	private static final String CUSTOM_FOOTER_LAYOUT_STYLE = "registration-footer-layout";
	private static final String CUSTOM_BUTTON_LAYOUT_STYLE = "registration-button-layout";
	private static final String CUSTOM_FORM_LAYOUT_STYLE = "registration-form-wrapper";
	private static final String CUSTOM_INNER_FORM_LAYOUT_STYLE = "registration-form-layout";

	@PropertyId("email")
	private TextField emailField = new LoginTextField();
	@PropertyId("password")
	private PasswordField passwordField = new LoginPasswordField();

	@Override
	public void onBind() {
		GridLayout innerFormLayout = new GridLayout(2, 1);
		innerFormLayout.setSpacing(true);
		innerFormLayout.setMargin(true);
		innerFormLayout.setWidth(FORM_LAYOUT_WIDTH);
		innerFormLayout.setStyleName(CUSTOM_INNER_FORM_LAYOUT_STYLE);
		innerFormLayout.setColumnExpandRatio(1, 1.0f);
		
		Label label = new LoginFieldLabel("Email");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.emailField);
		label = new LoginFieldLabel("Password");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.passwordField);
		
		HorizontalLayout titleLayout = new HorizontalLayout();
		titleLayout.setStyleName(CUSTOM_TITLE_LAYOUT_STYLE);
		titleLayout.setWidth(FORM_LAYOUT_WIDTH);
		titleLayout.setMargin(new MarginInfo(true, false, false, false));
		Label title = new Label("Sign In");
		title.setStyleName("registration-title-layout");
		title.setHeight(-1, Unit.PIXELS);
		titleLayout.addComponent(title);
		titleLayout.setComponentAlignment(title, Alignment.MIDDLE_LEFT);
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setStyleName(CUSTOM_BUTTON_LAYOUT_STYLE);
		buttonLayout.setWidth(FORM_LAYOUT_WIDTH);
		buttonLayout.setMargin(new MarginInfo(true, false, true, false));
		LoginButton saveButton = new LoginButton();
		saveButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				onRegisterButtonClicked();
			}
		});
		buttonLayout.addComponent(saveButton);
		buttonLayout.setComponentAlignment(saveButton, Alignment.MIDDLE_CENTER);
		
		VerticalLayout formLayout = new VerticalLayout();
		formLayout.setStyleName(CUSTOM_FORM_LAYOUT_STYLE);
		formLayout.setSizeFull();
		formLayout.addComponent(titleLayout);
		formLayout.setComponentAlignment(titleLayout, Alignment.MIDDLE_CENTER);
		formLayout.addComponent(innerFormLayout);
		formLayout.setComponentAlignment(innerFormLayout, Alignment.MIDDLE_CENTER);
		formLayout.addComponent(buttonLayout);
		formLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);
		
		HorizontalLayout footerLayout = new HorizontalLayout();
		footerLayout.setStyleName(CUSTOM_FOOTER_LAYOUT_STYLE);
		footerLayout.setWidth(VIEW_WIDTH);
		footerLayout.setMargin(true);
		Label footer = new Label("Not signed up yet? <a href=\"#\" target=\"_blank\">Register Here.</a> If you forgot your credentials, please <a href=\"#\" target=\"_blank\">Click Here.</a>");
		footer.setContentMode(ContentMode.HTML);
		footer.setWidth(-1, Unit.PIXELS);
		footerLayout.addComponent(footer);
		footerLayout.setComponentAlignment(footer, Alignment.MIDDLE_CENTER);
		
		addComponent(formLayout);
		addComponent(footerLayout);
		setWidth(VIEW_WIDTH);
		setHeight(VIEW_HEIGHT);
	}

	@Override
	public void textChange(TextChangeEvent event) {
		dispatch(new LoginFieldChangedEvent((Field<?>) event.getSource()), EventScope.PARENT);
	}
	
	private void onRegisterButtonClicked() {
		dispatch(new LoginSubmittedEvent(), EventScope.PARENT);
	}

	@Override
	public void validateRegistrationForm() {
	}

}

package com.conx.bi.portal.registration.ui.view.field;

import com.vaadin.ui.PasswordField;

public class RegistrationPasswordField extends PasswordField {
	private static final long serialVersionUID = 1018505040161998924L;

	private static final String EMPTY_STRING = "";
	private static final String DEFAULT_WIDTH = "100%";
	private static final String CUSTOM_STYLE = "registration-text-field";
	private static final String REQUIRED_ERROR_MESSAGE = "This is a required field.";
	
	public RegistrationPasswordField() {
		setNullRepresentation(EMPTY_STRING);
		setWidth(DEFAULT_WIDTH);
		setRequiredError(REQUIRED_ERROR_MESSAGE);
		setStyleName(CUSTOM_STYLE);
	}
	
	public RegistrationPasswordField(String caption) {
		this();
		this.setCaption(caption);
	}
}

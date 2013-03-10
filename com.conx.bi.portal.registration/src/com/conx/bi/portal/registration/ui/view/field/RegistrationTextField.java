package com.conx.bi.portal.registration.ui.view.field;

import com.vaadin.server.ErrorMessage;
import com.vaadin.ui.TextField;

public class RegistrationTextField extends TextField {
	private static final long serialVersionUID = 853554143745489336L;
	
	private static final String EMPTY_STRING = "";
	private static final String DEFAULT_WIDTH = "100%";
	private static final String CUSTOM_STYLE = "registration-text-field";
	private static final String INVALID_STYLE = "invalid";
	private static final String REQUIRED_ERROR_MESSAGE = "This is a required field.";
	
	public RegistrationTextField() {
		setNullRepresentation(EMPTY_STRING);
		setWidth(DEFAULT_WIDTH);
		setRequiredError(REQUIRED_ERROR_MESSAGE);
		setStyleName(CUSTOM_STYLE);
	}
	
	public RegistrationTextField(String caption) {
		this();
		this.setCaption(caption);
	}
	
	@Override
	public void setRequired(boolean required) {
		if (required) {
			addStyleName(INVALID_STYLE);
		} else {
			removeStyleName(INVALID_STYLE);
		}
		super.setRequired(required);
	}
	
	@Override
	public void setComponentError(ErrorMessage componentError) {
	}
}

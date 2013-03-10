package com.conx.bi.portal.registration.ui.view.field;

import com.vaadin.ui.Label;

public class RegistrationFieldLabel extends Label {
	private static final long serialVersionUID = 6362548911746009903L;
	
	public RegistrationFieldLabel(String text) {
		setValue(text);
		setWidth(-1, Unit.PIXELS);
		setStyleName("registration-field-label");
	}
}

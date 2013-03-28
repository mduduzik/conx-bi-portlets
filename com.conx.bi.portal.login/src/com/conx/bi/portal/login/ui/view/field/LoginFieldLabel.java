package com.conx.bi.portal.login.ui.view.field;

import com.vaadin.ui.Label;

public class LoginFieldLabel extends Label {
	private static final long serialVersionUID = 6362548911746009903L;
	
	public LoginFieldLabel(String text) {
		setValue(text);
		setWidth(-1, Unit.PIXELS);
		setStyleName("registration-field-label");
	}
}

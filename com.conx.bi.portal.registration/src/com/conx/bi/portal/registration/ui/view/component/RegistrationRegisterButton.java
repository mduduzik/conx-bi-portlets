package com.conx.bi.portal.registration.ui.view.component;

import com.vaadin.ui.Button;

public class RegistrationRegisterButton extends Button {
	private static final long serialVersionUID = -4609376603395861896L;
	
	private static final String CUSTOM_STYLE = "registration-register-button";
	private static final String BUTTON_CAPTION = "Create My Account";
	
	public RegistrationRegisterButton() {
		super(BUTTON_CAPTION);
		setStyleName(CUSTOM_STYLE);
	}
}

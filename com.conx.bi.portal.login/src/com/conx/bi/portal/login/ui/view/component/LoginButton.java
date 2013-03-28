package com.conx.bi.portal.login.ui.view.component;

import com.vaadin.ui.Button;

public class LoginButton extends Button {
	private static final long serialVersionUID = -4609376603395861896L;
	
	private static final String CUSTOM_STYLE = "registration-register-button";
	private static final String BUTTON_CAPTION = "Sign In";
	
	public LoginButton() {
		super(BUTTON_CAPTION);
		setStyleName(CUSTOM_STYLE);
	}
}

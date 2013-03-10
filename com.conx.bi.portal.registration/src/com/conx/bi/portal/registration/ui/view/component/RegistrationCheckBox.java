package com.conx.bi.portal.registration.ui.view.component;

import com.vaadin.ui.CheckBox;

public class RegistrationCheckBox extends CheckBox {
	private static final long serialVersionUID = -2617540641671022931L;

	private static final String CHECKBOX_CAPTION = "Yes! Please email me with news and updates.";
	private static final String CUSTOM_STYLE = "registration-checkbox";
	
	public RegistrationCheckBox() {
		super(CHECKBOX_CAPTION);
		setStyleName(CUSTOM_STYLE);
	}
}

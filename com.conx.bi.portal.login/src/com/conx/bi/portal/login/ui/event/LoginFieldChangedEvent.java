package com.conx.bi.portal.login.ui.event;

import org.pakhama.vaadin.mvp.event.impl.Event;

import com.vaadin.ui.Field;

public class LoginFieldChangedEvent extends Event {
	private static final long serialVersionUID = 7975244927430526434L;
	
	private Field<?> field;

	public LoginFieldChangedEvent(Field<?> field) {
		this.field = field;
	}
	
	public Field<?> getField() {
		return field;
	}
}

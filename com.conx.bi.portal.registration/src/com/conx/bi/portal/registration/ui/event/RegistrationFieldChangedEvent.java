package com.conx.bi.portal.registration.ui.event;

import org.pakhama.vaadin.mvp.event.Event;
import org.pakhama.vaadin.mvp.event.EventScope;

import com.vaadin.ui.Field;

public class RegistrationFieldChangedEvent extends Event {
	private static final long serialVersionUID = 7975244927430526434L;
	
	private Field<?> field;

	public RegistrationFieldChangedEvent(Field<?> field) {
		this.field = field;
		setScope(EventScope.PARENT);
	}
	
	public Field<?> getField() {
		return field;
	}
}

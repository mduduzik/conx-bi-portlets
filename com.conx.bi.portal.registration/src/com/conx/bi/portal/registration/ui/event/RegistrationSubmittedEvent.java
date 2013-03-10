package com.conx.bi.portal.registration.ui.event;

import org.pakhama.vaadin.mvp.event.Event;
import org.pakhama.vaadin.mvp.event.EventScope;

public class RegistrationSubmittedEvent extends Event {
	private static final long serialVersionUID = 7688510622588242964L;
	
	public RegistrationSubmittedEvent() {
		setScope(EventScope.PARENT);
	}
}

package com.conx.bi.portal.registration.ui;

import org.pakhama.vaadin.mvp.event.annotation.Listener;
import org.pakhama.vaadin.mvp.presenter.Presenter;

import com.conx.bi.portal.registration.ui.event.RegistrationSubmittedEvent;
import com.conx.bi.portal.registration.ui.view.IRegistrationView;
import com.conx.bi.portal.registration.ui.view.RegistrationView;

public class RegistrationPresenter extends Presenter<IRegistrationView> {
	private static final long serialVersionUID = -8834988576405124883L;

	@Override
	public void init() {
	}

	@Override
	public Class<? extends IRegistrationView> view() {
		return RegistrationView.class;
	}

	@Listener(event = RegistrationSubmittedEvent.class)
	public void onRegister() {
		getView().validateRegistrationForm();
	}
}

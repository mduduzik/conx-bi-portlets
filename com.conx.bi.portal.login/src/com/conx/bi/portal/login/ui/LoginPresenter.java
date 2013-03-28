package com.conx.bi.portal.login.ui;

import org.pakhama.vaadin.mvp.annotation.event.EventListener;
import org.pakhama.vaadin.mvp.presenter.impl.Presenter;

import com.conx.bi.portal.login.ui.event.LoginSubmittedEvent;
import com.conx.bi.portal.login.ui.view.ILoginView;

public class LoginPresenter extends Presenter<ILoginView> {
	private static final long serialVersionUID = -8834988576405124883L;

	@EventListener(event = LoginSubmittedEvent.class)
	public void onRegister() {
		getView().validateRegistrationForm();
	}
}

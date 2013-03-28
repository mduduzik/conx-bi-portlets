package com.conx.bi.portal.login;

import org.pakhama.vaadin.mvp.ui.MVPUI;

import com.conx.bi.portal.login.ui.LoginPresenter;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@Theme("registration-theme")
@SuppressWarnings("serial")
public class LoginUI extends MVPUI {

	@Override
	protected void init(VaadinRequest request) {
		LoginPresenter registrationPresenter = createPresenter(LoginPresenter.class);

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Component registrationComponent = registrationPresenter.getView().getComponent();
		layout.addComponent(registrationComponent);
		layout.setComponentAlignment(registrationComponent, Alignment.MIDDLE_CENTER);
	}

}
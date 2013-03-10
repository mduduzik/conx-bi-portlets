package com.conx.bi.portal.registration;

import org.pakhama.vaadin.mvp.event.EventBusFactory;
import org.pakhama.vaadin.mvp.event.IEventBus;
import org.pakhama.vaadin.mvp.presenter.PresenterFactory;

import com.conx.bi.portal.registration.ui.RegistrationPresenter;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@Theme("registration-theme")
@SuppressWarnings("serial")
public class RegistrationUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		EventBusFactory eventBusFactory = new EventBusFactory();
		IEventBus eventBus = eventBusFactory.create();
		PresenterFactory presenterFactory = new PresenterFactory(eventBus);
		RegistrationPresenter registrationPresenter = presenterFactory.create(RegistrationPresenter.class);

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		layout.addComponent(registrationPresenter.getView());
		layout.setComponentAlignment(registrationPresenter.getView(), Alignment.MIDDLE_CENTER);
	}

}
package com.conx.bi.portal.registration.ui.view;

import org.pakhama.vaadin.mvp.view.View;

import com.conx.bi.portal.registration.ui.event.RegistrationFieldChangedEvent;
import com.conx.bi.portal.registration.ui.event.RegistrationSubmittedEvent;
import com.conx.bi.portal.registration.ui.view.component.RegistrationCheckBox;
import com.conx.bi.portal.registration.ui.view.component.RegistrationRegisterButton;
import com.conx.bi.portal.registration.ui.view.field.RegistrationFieldLabel;
import com.conx.bi.portal.registration.ui.view.field.RegistrationPasswordField;
import com.conx.bi.portal.registration.ui.view.field.RegistrationTextField;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class RegistrationView extends View implements IRegistrationView, TextChangeListener {
	private static final long serialVersionUID = -212578951543188340L;

	private static final String COMPARISON_EXCEPTION_MESSAGE = "This field must be identical to the password field.";
	private static final String EMAIL_EXCEPTION_MESSAGE = "The provided email address is not valid.";
	private static final String REGISTRATION_DESCRIPTION_MESSAGE = "Start your fully functional 30-day trial account now - pay within the next thirty days and continue working without interruption.";
	private static final String FORM_LAYOUT_WIDTH = "480px";
	private static final String VIEW_WIDTH = "700px";
	private static final String VIEW_HEIGHT = "100%";
	private static final String PHONE_INPUT_PROMPT = "e.g. 555-867-5309";
	private static final String EMAIL_INPUT_PROMPT = "person@company.com";
	private static final String CUSTOM_TITLE_LAYOUT_STYLE = "registration-title-layout";
	private static final String CUSTOM_DESCRIPTION_LAYOUT_STYLE = "registration-description-layout";
	private static final String CUSTOM_HEADER_LAYOUT_STYLE = "registration-header-layout";
	private static final String CUSTOM_FOOTER_LAYOUT_STYLE = "registration-footer-layout";
	private static final String CUSTOM_BUTTON_LAYOUT_STYLE = "registration-button-layout";
	private static final String CUSTOM_FORM_LAYOUT_STYLE = "registration-form-wrapper";
	private static final String CUSTOM_INNER_FORM_LAYOUT_STYLE = "registration-form-layout";

	@PropertyId("firstName")
	private TextField firstNameField = new RegistrationTextField();
	@PropertyId("lastName")
	private TextField lastNameField = new RegistrationTextField();
	@PropertyId("email")
	private TextField emailField = new RegistrationTextField();
	@PropertyId("phone")
	private TextField phoneField = new RegistrationTextField();
	@PropertyId("login")
	private TextField loginField = new RegistrationTextField();
	@PropertyId("password")
	private PasswordField passwordField = new RegistrationPasswordField();
	@PropertyId("confirmPassword")
	private PasswordField confirmPasswordField = new RegistrationPasswordField();
	@PropertyId("organizationName")
	private TextField organizationNameField = new RegistrationTextField();
	@PropertyId("emailSubscriber")
	private CheckBox emailSubscriptionField = new RegistrationCheckBox();

	@Override
	public void init() {
		GridLayout innerFormLayout = new GridLayout(2, 1);
		innerFormLayout.setSpacing(true);
		innerFormLayout.setMargin(true);
		innerFormLayout.setWidth(FORM_LAYOUT_WIDTH);
		innerFormLayout.setStyleName(CUSTOM_INNER_FORM_LAYOUT_STYLE);
		innerFormLayout.setColumnExpandRatio(1, 1.0f);
		
		this.firstNameField.addTextChangeListener(this);
		this.lastNameField.addTextChangeListener(this);
		this.emailField.addTextChangeListener(this);
		this.phoneField.addTextChangeListener(this);
		this.loginField.addTextChangeListener(this);
		this.passwordField.addTextChangeListener(this);
		this.confirmPasswordField.addTextChangeListener(this);
		this.organizationNameField.addTextChangeListener(this);

		this.phoneField.setInputPrompt(PHONE_INPUT_PROMPT);
		this.emailField.setInputPrompt(EMAIL_INPUT_PROMPT);

		this.confirmPasswordField.addValidator(new IdenticalFieldValidator(this.passwordField, COMPARISON_EXCEPTION_MESSAGE));
		this.emailField.addValidator(new EmailValidator(EMAIL_EXCEPTION_MESSAGE));

		RegistrationFieldLabel label = new RegistrationFieldLabel("First Name");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.firstNameField);
		label = new RegistrationFieldLabel("Last Name");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.lastNameField);
		label = new RegistrationFieldLabel("Email");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.emailField);
		label = new RegistrationFieldLabel("Phone Number");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.phoneField);
		label = new RegistrationFieldLabel("Login");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.loginField);
		label = new RegistrationFieldLabel("Password");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.passwordField);
		label = new RegistrationFieldLabel("Confirm Password");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.confirmPasswordField);
		label = new RegistrationFieldLabel("Organization Name");
		innerFormLayout.addComponent(label);
		innerFormLayout.setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
		innerFormLayout.addComponent(this.organizationNameField);
		
		HorizontalLayout titleLayout = new HorizontalLayout();
		titleLayout.setStyleName(CUSTOM_TITLE_LAYOUT_STYLE);
		titleLayout.setWidth(FORM_LAYOUT_WIDTH);
		titleLayout.setMargin(new MarginInfo(true, false, false, false));
		Label title = new Label("Create Your Owner Account");
		title.setStyleName("registration-title-layout");
		title.setHeight(-1, Unit.PIXELS);
		titleLayout.addComponent(title);
		titleLayout.setComponentAlignment(title, Alignment.MIDDLE_LEFT);
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setStyleName(CUSTOM_BUTTON_LAYOUT_STYLE);
		buttonLayout.setWidth(FORM_LAYOUT_WIDTH);
		buttonLayout.setMargin(new MarginInfo(true, false, true, false));
		RegistrationRegisterButton saveButton = new RegistrationRegisterButton();
		saveButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				onRegisterButtonClicked();
			}
		});
		buttonLayout.addComponent(this.emailSubscriptionField);
		buttonLayout.setComponentAlignment(this.emailSubscriptionField, Alignment.MIDDLE_LEFT);
		buttonLayout.addComponent(saveButton);
		buttonLayout.setComponentAlignment(saveButton, Alignment.MIDDLE_RIGHT);
		
		VerticalLayout formLayout = new VerticalLayout();
		formLayout.setStyleName(CUSTOM_FORM_LAYOUT_STYLE);
		formLayout.setSizeFull();
		formLayout.addComponent(titleLayout);
		formLayout.setComponentAlignment(titleLayout, Alignment.MIDDLE_CENTER);
		formLayout.addComponent(innerFormLayout);
		formLayout.setComponentAlignment(innerFormLayout, Alignment.MIDDLE_CENTER);
		formLayout.addComponent(buttonLayout);
		formLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);
		
		HorizontalLayout footerLayout = new HorizontalLayout();
		footerLayout.setStyleName(CUSTOM_FOOTER_LAYOUT_STYLE);
		footerLayout.setWidth(VIEW_WIDTH);
		footerLayout.setMargin(true);
		Label footer = new Label("By registering you agree to Business Convergence´s <a href=\"http://cloudforge.com/terms-of-service\" target=\"_blank\">Terms of Service</a>");
		footer.setContentMode(ContentMode.HTML);
		footer.setWidth(-1, Unit.PIXELS);
		footerLayout.addComponent(footer);
		footerLayout.setComponentAlignment(footer, Alignment.MIDDLE_CENTER);
		
		CssLayout headerLayout = new CssLayout();
		headerLayout.setStyleName(CUSTOM_HEADER_LAYOUT_STYLE);
		headerLayout.setHeight("45px");
		headerLayout.setWidth(VIEW_WIDTH);
		Label header = new Label("Free 30 Day Trial");
		header.setWidth(-1, Unit.PIXELS);
		Image headerImage = new Image(null, new ThemeResource("img/signup-user.png"));
		headerImage.setStyleName("registration-signup-img");
		headerLayout.addComponent(headerImage);
		headerLayout.addComponent(header);
		
		VerticalLayout descriptionLayout = new VerticalLayout();
		descriptionLayout.setStyleName(CUSTOM_DESCRIPTION_LAYOUT_STYLE);
		descriptionLayout.setWidth(VIEW_WIDTH);
		descriptionLayout.setMargin(new MarginInfo(false, true, true, true));
		Label description = new Label(REGISTRATION_DESCRIPTION_MESSAGE);
		descriptionLayout.addComponent(description);
		
		addComponent(headerLayout);
		addComponent(descriptionLayout);
		addComponent(formLayout);
		addComponent(footerLayout);
		setWidth(VIEW_WIDTH);
		setHeight(VIEW_HEIGHT);
	}

	private class IdenticalFieldValidator implements Validator {
		private static final long serialVersionUID = -2345547475481775559L;

		private Field<?> identicalField;
		private String errorMessage;

		public IdenticalFieldValidator(Field<?> identicalField, String errorMessage) {
			assert (identicalField != null) : "The field for comparison was null.";
			assert (errorMessage != null) : "The error message was null.";

			this.identicalField = identicalField;
			this.errorMessage = errorMessage;
		}

		@Override
		public void validate(Object value) throws InvalidValueException {
			if (value == null) {
				if (this.identicalField.getValue() != null) {
					throw new InvalidValueException(this.errorMessage);
				}
			} else {
				if (!value.equals(this.identicalField.getValue())) {
					throw new InvalidValueException(this.errorMessage);
				}
			}
		}
	}

	@Override
	public void textChange(TextChangeEvent event) {
		fire(new RegistrationFieldChangedEvent((Field<?>) event.getSource()));
	}
	
	private void onRegisterButtonClicked() {
		fire(new RegistrationSubmittedEvent());
	}

	@Override
	public void validateRegistrationForm() {
		this.firstNameField.setRequired(!this.firstNameField.isRequired());
	}

}

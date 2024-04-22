package com.book.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class emailservice {
	@Autowired
	private JavaMailSender jms;
	public void sendEmail(String to, String sub, String message) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(to);
		sm.setSubject(sub);
		sm.setText(message);
		jms.send(sm);
	}
}

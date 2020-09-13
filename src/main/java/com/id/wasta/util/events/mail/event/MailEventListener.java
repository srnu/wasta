package com.id.wasta.util.events.mail.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.id.wasta.util.events.mail.service.MailService;

@Component
public class MailEventListener implements ApplicationListener<MailEvent> {

	@Autowired
	MailService mailService;

	public void onApplicationEvent(MailEvent event) {
		try {
			this.mailService.sendMail(event.getMailBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
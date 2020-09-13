package com.id.wasta.util.events.mail.event;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.context.ApplicationEvent;

import com.id.wasta.bean.MailBean;

public class MailEvent extends ApplicationEvent{
	
  private static final long serialVersionUID = 1L;
  private MailBean mailBean;

  public MailEvent(MailBean mailBean){
	  super("Mail Event");
	  this.mailBean = mailBean;
  }
  
  public MailEvent(String fromMailId, String toMailId, String templateName,String mailTemplate,String subject){
	  super("Mail Event");
	  try {
		  this.mailBean = new MailBean(new InternetAddress(fromMailId), toMailId, null, null, templateName, mailTemplate,subject, null);
	  } catch (AddressException e) {
		  e.printStackTrace();
	  }
  }


  public MailBean getMailBean() {
	  return mailBean;
  }
  
}
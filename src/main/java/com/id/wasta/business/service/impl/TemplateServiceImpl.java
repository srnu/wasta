package com.id.wasta.business.service.impl;



import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.id.wasta.bean.Attachment;
import com.id.wasta.bean.MailBean;
import com.id.wasta.business.service.TemplateService;
import com.id.wasta.data.repository.jpa.TIdTemplateMasterRepository;
import com.id.wasta.util.events.mail.event.MailEvent;


@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Resource
	private TIdTemplateMasterRepository tIdTemplateMastertrepository;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	private static final Logger log = Logger.getLogger(TemplateServiceImpl.class);
	
	private static final String EMAIL_FROM = "WastaWorld Team";

	private static final String TEMPLATE_MAIL = "MAIL";
	
	private static final String VELOCITY_OBJECT = "object";
	
	private static final String FIND_AND = "\\r\\n";

	private static final String REPLACE = "\n";
	
	@Override
	public String fillTemplate(Object templateObject,String templateName,String template){
		StringWriter writer = new StringWriter();
		VelocityContext velocityContext=new VelocityContext();
		velocityContext.put(VELOCITY_OBJECT, templateObject);
		velocityEngine.evaluate(velocityContext, writer,templateName, template);
		return writer.toString().trim().replaceAll(FIND_AND, REPLACE);
	} 
	
	@Override
	public void createMailTemplateAndSend(final String templateName,String fromAddress, String[] toAddresslist,Map<String,Object> templateObject, List<Attachment> attachments){
		try {
			List<Object[]> selectedTemplate = tIdTemplateMastertrepository.getTemplateSubjectAndContent(templateName,TEMPLATE_MAIL);
			if(selectedTemplate!=null && selectedTemplate.size()>0){
				for(Object[] template : selectedTemplate){
					String subject;
						if(template[0].toString().equals("DEFAULT PASSWORD CREATION")) {
							subject = "Welcome to WastaWorld";
						}
						else {
							subject = template[0].toString();
						}
						subject = fillTemplate(templateObject, templateName, subject);	
						String mailContent = template[1].toString();
						mailContent = fillTemplate(templateObject,templateName,mailContent);	
						for(String toAddress:toAddresslist)
						{
						sendMail(templateName, templateObject,fromAddress,toAddress,mailContent, subject, attachments);
						}
					}
			}else{
				log.debug("Exception sending Email -->Invalid Template. Template Not available in Database -->"+templateName);
			}
		} catch (Exception e) {
			log.debug("Exception sending Email -->");
		}
	}
	
	
	private void sendMail(String templateName, Map<String,Object> templateObject, String fromAddress,String toAddress, String mailContent, String subject, List<Attachment> attachments){
		
		InternetAddress from = null;
	     try {
				from = new InternetAddress(fromAddress,EMAIL_FROM);
				eventPublisher.publishEvent(new MailEvent(new MailBean(from,toAddress,null,null,templateName, mailContent, subject,null)));
			} catch (UnsupportedEncodingException e) {
				log.debug("Exception sending Email -->Invalid From Mail Address --> "+fromAddress);
			}
       
	}

	@Override
	public void sendMailForChangeDefultPassword(Map<String, Object> mailValues) {
		try {
			List<Object[]> selectedTemplate = tIdTemplateMastertrepository.getTemplateSubjectAndContent(mailValues.get("templateName").toString(),TEMPLATE_MAIL);
			if(selectedTemplate!=null && selectedTemplate.size()>0 ){
				for(Object[] template : selectedTemplate){
						String subject = template[0].toString();
						subject = fillTemplate(mailValues, mailValues.get("templateName").toString(), subject);	
						String mailContent = template[1].toString();
						mailContent = fillTemplate(mailValues,mailValues.get("templateName").toString(),mailContent);	
						sendMail(mailValues.get("templateName").toString(), mailValues,mailValues.get("fromAddress").toString(),mailValues.get("toAddress").toString(),mailContent, subject, null);
					}
			}else{
				log.debug("Exception sending Email -->Invalid Template. Template Not available in Database -->"+mailValues.get("templateName").toString());
			}
		} catch (Exception e) {
			log.debug("Exception sending Email -->");
		}
		
	}
	
	
}

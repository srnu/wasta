package com.id.wasta.business.service;

import java.util.List;
import java.util.Map;

import com.id.wasta.bean.Attachment;



public interface TemplateService {
	
	public String fillTemplate(Object obj, String templateName,String template);
	public void createMailTemplateAndSend(String activityCode, String fromAddress,String[] toAddress,Map<String,Object> templateObject, List<Attachment> attachments);
	public void sendMailForChangeDefultPassword(Map<String,Object> mailValues);
	
	
}

package com.id.wasta.bean;

import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailBean {
	
	private InternetAddress fromMailId;
	private String toMailIds;
	private String ccMailIds;
	private String bccMailIds;
	private String templateName;
	//private Map<String,Object> templateObject;//Velocity Template Binding Object
	private String mailContent;//Non Template Simple Mail Content
	private String subject;
	private List<Attachment> attachments;
	private List<MultiPartInline> multiPartInlines;
	
	public MailBean() {
		super();
	}

	public MailBean(InternetAddress fromMailId, String toMailIds,
			String ccMailIds, String bccMailIds,
			String templateName,  String mailContent,
			String subject, List<Attachment> attachments,
			List<MultiPartInline> multiPartInlines) {
		super();
		this.fromMailId = fromMailId;
		this.toMailIds = toMailIds;
		this.ccMailIds = ccMailIds;
		this.bccMailIds = bccMailIds;
		this.templateName = templateName;
		this.mailContent = mailContent;
		this.subject = subject;
		this.attachments = attachments;
		this.multiPartInlines = multiPartInlines;
	}
	
	public MailBean(InternetAddress fromMailId, String toMailIds,
			String ccMailIds, String bccMailIds,
			String templateName, String mailContent,
			String subject, List<Attachment> attachments) {
		super();
		this.fromMailId = fromMailId;
		this.toMailIds = toMailIds;
		this.ccMailIds = ccMailIds;
		this.bccMailIds = bccMailIds;
		this.templateName = templateName;
		this.mailContent = mailContent;
		this.subject = subject;
		this.attachments = attachments;
	}
	
	//Simple Mail without Attachments & Template
	public MailBean(String fromMailId, String toMailId, String mailContent,String subject) {
		super();
		try {
			this.fromMailId = new InternetAddress(fromMailId);
			this.toMailIds = toMailId;
			this.mailContent = mailContent;
			this.subject = subject;
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
	public MailBean(String fromMailId, String toMailId,String subject,String templateName, List<Attachment> attachments) {
		super();
		try {
			this.fromMailId = new InternetAddress(fromMailId);
			this.toMailIds =  toMailId;
			this.subject = subject;
			this.templateName = templateName;
			this.attachments = attachments;
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
	 
	
	 
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	 
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public InternetAddress getFromMailId() {
		return fromMailId;
	}
	public void setFromMailId(InternetAddress fromMailId) {
		this.fromMailId = fromMailId;
	}
 
	
	
	public String getToMailIds() {
		return toMailIds;
	}

	public void setToMailIds(String toMailIds) {
		this.toMailIds = toMailIds;
	}

	public String getCcMailIds() {
		return ccMailIds;
	}

	public void setCcMailIds(String ccMailIds) {
		this.ccMailIds = ccMailIds;
	}

	public String getBccMailIds() {
		return bccMailIds;
	}

	public void setBccMailIds(String bccMailIds) {
		this.bccMailIds = bccMailIds;
	}

	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	public List<MultiPartInline> getMultiPartInlines() {
		return multiPartInlines;
	}
	public void setMultiPartInlines(List<MultiPartInline> multiPartInlines) {
		this.multiPartInlines = multiPartInlines;
	}
	
	public class MultiPartInline{
		
		private String fileName;
		private String filePath;
		private String contentId;
		private String contentType;
		
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public String getContentId() {
			return contentId;
		}
		public void setContentId(String contentId) {
			this.contentId = contentId;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		
	}
	
}

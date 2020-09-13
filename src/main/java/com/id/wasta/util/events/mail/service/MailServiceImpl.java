package com.id.wasta.util.events.mail.service;

import java.io.File;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.id.wasta.bean.Attachment;
import com.id.wasta.bean.MailBean;
import com.id.wasta.bean.MailBean.MultiPartInline;


@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = Logger.getLogger(MailService.class);

	@Override
	public void sendMail(MailBean mailBean){
		try {
			MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			mimeMessage.setFrom(mailBean.getFromMailId());
			mimeMessage.addRecipients(Message.RecipientType.TO,mailBean.getToMailIds());
			if(mailBean.getBccMailIds()!=null){
				mimeMessage.addRecipients(Message.RecipientType.BCC,mailBean.getBccMailIds());
			}
			if(mailBean.getCcMailIds()!=null){
				mimeMessage.addRecipients(Message.RecipientType.CC,mailBean.getCcMailIds());	
			}
			mimeMessage.setSubject(mailBean.getSubject());
			Multipart mp =null;
			if(mailBean.getMultiPartInlines()!=null || mailBean.getAttachments()!=null){
				if(mailBean.getMultiPartInlines()!=null){
					loadMultipartInline(mimeMessage, mp, mailBean.getMultiPartInlines());
				}
				
				if(mailBean.getAttachments()!=null){
					loadAttachements(mimeMessage, mp, mailBean.getAttachments());
				}
			}
			
			if (mailBean.getTemplateName() != null) {
				if(mp==null){
					mp = new MimeMultipart();
				}
				MimeBodyPart part = new MimeBodyPart();
				part.setContent(mailBean.getMailContent(),"text/html");
				mp.addBodyPart(part);
				mimeMessage.setContent(mp);
			}else{
				if(mailBean.getMailContent()!=null){
					mimeMessage.setContent(mailBean.getMailContent(), "text/html");
				}else{
					mimeMessage.setContent("", "text/html");	
				}
			}
			this.mailSender.send(mimeMessage);
		} catch (Exception e) {
			logger.error("Error Occured while Sending Mail ---->" + e);
		}
	}
	
	private void loadAttachements(MimeMessage mimeMessage, Multipart mp, List<Attachment> attachments) throws MessagingException{
		if(mp==null){
			mp = new MimeMultipart();
		}
		for(Attachment attachment : attachments){
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setFileName(attachment.getFileName());//"Flight Confirmation.pdf"
			mimeBodyPart.setContent(attachment.getFileContent(), MediaType.APPLICATION_OCTET_STREAM_VALUE);//"application/pdf");
			mimeBodyPart.setDisposition(Part.ATTACHMENT);
		    mp.addBodyPart(mimeBodyPart);
		}
		mimeMessage.setContent(mp);
	}
	
	private void loadMultipartInline(MimeMessage mimeMessage, Multipart mp, List<MultiPartInline> multiPartInlines) throws MessagingException{
		 if(mp==null){
			mp = new MimeMultipart();
		 }
		 for(MultiPartInline multiPartInline: multiPartInlines){
			 MimeBodyPart mimeBodyPart = new MimeBodyPart();
			 File emailImage = new File(multiPartInline.getFilePath()+ multiPartInline.getFileName());
			 FileDataSource fds = new FileDataSource(emailImage);
			 mimeBodyPart.setDataHandler(new DataHandler(fds));
			 mimeBodyPart.setHeader("Content-ID", multiPartInline.getContentId());
			 mimeBodyPart.setHeader("Content-Type", multiPartInline.getContentType());
			 mimeBodyPart.setDisposition(MimeBodyPart.INLINE);
			 mp.addBodyPart(mimeBodyPart);
		 }
		 mimeMessage.setContent(mp);
	}
	
}
package com.home.practice.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailImp implements Email {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper=new MimeMessageHelper(message,true);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true); //true indicates we can provide html tags in body
			mailSender.send(message);// true indicates multipart message
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

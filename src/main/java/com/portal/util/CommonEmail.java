package com.portal.util;

import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.portal.model.User;

public class CommonEmail {
	private String smtpHost = "smtp.gmail.com";
	private int smtpPort = 465;
	
	public void sendSignUpMail(User user){
		String subject = "Welcome to TripToParadise.";
		String from = "ssd.3muskeeters@gmail.com";
		String to = user.getEmail();
		
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", smtpHost);  
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");  
		properties.put("mail.smtp.socketFactory.port", "465");  
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
		properties.put("mail.smtp.port", "465");  

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication("ssd.3muskeeters@gmail.com", "allForOne");  
			}  
		});  

		Message msg = new MimeMessage(session);
		try{
			
		
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from,"TripToParadise"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
			
			
			 VelocityEngine ve = new VelocityEngine();
			 ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			 ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			 try {
				ve.init();
			} catch (Exception e1) {
				e1.printStackTrace();
			}    
			 VelocityContext context = new VelocityContext();
//				 ArrayList list = new ArrayList();
//			        Map map;
//			        for(HotelSearchResultFB hotelSearchResultFB:selectedHotelsForBid){
//			        	 map = new HashMap();
//			        	 map.put("hotelname", hotelSearchResultFB.getHotelName());
//			        	 list.add(map);
//			        }
//			        context.put("hotelList", list);
//			      context.put("bidcart", bidCartPojo);
			 context.put("user", user);
			     
				 Template template = ve.getTemplate("emailTemplate/signup.vm");
				 StringWriter writer = new StringWriter();
				 template.merge(context, writer);
				 msg.setContent(writer.toString(), "text/html; charset=utf-8");
				 msg.setSentDate(new Date());
				 Transport.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

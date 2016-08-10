package com.lem.service.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class MailConfig {
	
	@Value("${mail.smtp.host}")
	private String mailSmtpHost;
	@Value("${mail.smtp.port}")
	private int mailSmtpPort;
	@Value("${mail.smtp.username}")
	private String mailSmtpUsername;
	@Value("${mail.smtp.password}")
	private String mailSmtpPassword;
	
	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(mailSmtpHost);
		javaMailSender.setPort(mailSmtpPort);
		javaMailSender.setUsername(mailSmtpUsername);
		javaMailSender.setPassword(mailSmtpPassword);
		javaMailSender.setJavaMailProperties(mailProperties());
		return javaMailSender;
	}
	
	private Properties mailProperties(){
		Properties properties = new Properties();
		properties.setProperty("mail.transprot.protocol", "smtp");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.mime.charset", "UTF-8");
        properties.setProperty("mail.debug", "false");
        properties.setProperty("mail.smtps.**ssl.enable", "false");
        properties.setProperty("mail.smtps.**ssl.required", "false");
		return properties;
	}

}

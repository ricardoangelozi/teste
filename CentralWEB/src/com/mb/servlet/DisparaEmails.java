package com.mb.servlet;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DisparaEmails implements Runnable{
	
	private String nome;
	private String email;
	private String tel;
	private String duvidas;
	private String observa;
	
	public DisparaEmails(String nome , String email, String tel, String duvidas, String observa){
		
		this.nome = nome;
		this.email = email;
		this.tel = tel;
		this.duvidas = duvidas;
		this.observa = observa;
		
	}

	@Override
	public void run() {
	
		
			Properties props = new Properties();
			props.put("mail.smtp.host", "mail.centraldarevendedora.com.br");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("contato@centraldarevendedora.com.br", "Hiro44s@2him@");
	            }
	        });

	        MimeMessage message = new MimeMessage(session);
	        try {
				message.setFrom(new InternetAddress("contato@centraldarevendedora.com.br"));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress("contato@centraldarevendedora.com.br"));
			    message.setSubject(duvidas);
			    message.setText("Nome:  " + nome + "  Email: " + email + "  Telefone Contato: " + tel + " Observação " + observa);
			    Transport.send(message);
			    System.out.println("Envio com sucesso");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

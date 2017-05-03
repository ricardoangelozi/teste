package com;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.model.Cadastro_Central;

public class Utils {
	
	public static String CAMINHO_ARQ = System.getProperty("user.home");
	
	public static String converteData(Date converter){
		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String convertida = data.format(converter);
		return convertida;
		
	}
	
	
	
	public static Date converteDataString(String dataString){
		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date convertida = null;
		try {
			convertida = (Date) data.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertida;
		
	}
	
	public static String gerarNovaSenha() {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
				"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		String senha = "";
		for (int x = 0; x < 4; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}
		return senha;
	}
	
	public static void mensagens(String campo) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "", campo));
	}
	
	public static String convertStringToMd5(String valor) {
		MessageDigest mDigest;
		try {
			// Instanciamos o nosso HASH MD5, poderíamos usar outro como
			// SHA, por exemplo, mas optamos por MD5.
			mDigest = MessageDigest.getInstance("MD5");
			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
			// Convertemos os bytes para hexadecimal, assim podemos salvar
			// no banco para posterior comparação se senhas
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
			}

			return sb.toString();
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void mandarEmail(String senha, String email, String msg, String assunto){
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.centraldarevendedora.com.br");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("financeiro@centraldarevendedora.com.br", "Hiro44s@2him@");
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
			message.setFrom(new InternetAddress("sistema@villaverde.com.br"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		    message.setSubject(assunto);
		    message.setText(msg + " Email: " + email + " Senha: " + senha);
		    Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void mandarEmailSindico(Cadastro_Central morador, String email){
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.boxbrain.com.br");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("contato@boxbrain.com.br", "ju210406");
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
			message.setFrom(new InternetAddress("sistema@villaverde.com.br"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("ricardoangelozi@gmail.com"));
		    message.setSubject("Liberação de acesso");
		    //message.setText("Existe um usuario a liberar " + email + " Bloco " + morador.getUnidade().getBloco().getBloco() + " Endereco " + morador.getUnidade().getUnidade());
		    Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void mandarEmailReserva(String email, String msg, String assunto){
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.boxbrain.com.br");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("contato@boxbrain.com.br", "ju210406");
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
			message.setFrom(new InternetAddress("sistema@villaverde.com.br"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		    message.setSubject(assunto);
		    message.setText(msg);
		    Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

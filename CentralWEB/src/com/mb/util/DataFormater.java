package com.mb.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum DataFormater {
	
	DATA("dd/MM/yyyy"),
	DATA_YYYY_MM_DD("yyyy-MM-dd"),
	DATA_HORA_12("dd/MM/yyyy hh:mm:ss"),
	DATA_HORA_24("dd/MM/yyyy HH:mm:ss");
	
	private String mascara;

	
	
	private DataFormater(String mascara) {
		this.setMascara(mascara);
	}

	public String getMascara() {
		return mascara;
	}

	private void setMascara(String mascara) {
		this.mascara = mascara;
	}
	
	public String getString(Date date){
		if (date == null){
			return null;
		}
		
		return (new SimpleDateFormat(this.getMascara())).format(date);
	}
	
	public Date getDate(String date){
		if (date == null){
			return null;
		}
		try {
			return (new SimpleDateFormat(this.getMascara())).parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}

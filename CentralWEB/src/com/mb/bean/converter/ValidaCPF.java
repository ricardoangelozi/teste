package com.mb.bean.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

public class ValidaCPF {

	private String cpf;

	/**Metodo validador de CPF do JSF**/
	public void validaCPF(FacesContext context, UIComponent component, Object value) {
		String valor = (String) value;
		System.out.println(valor);
		Pattern padrao = Pattern.compile("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}");
		Matcher pesquisa = padrao.matcher(valor);
		if (!pesquisa.matches() || !validaCPF(valor)) {
			((UIInput) component).setValid(false);
			mostrarMensagem("CPF: (" + valor + ") é Inválido");
		} 
	}

	public void mostrarMensagem(String msg) {
		System.out.println(msg);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		facesContext.addMessage(null, facesMessage);
	}

	/**
	 * Metodo para validar CPF:
	 * Font: http://javafree.uol.com.br/topic-860897-Validar-CPF--CNPJ-e-consultar-CEP.html
	 **/
	public boolean validaCPF(String strCpf) { // formato XXX.XXX.XXX-XX
		if (!strCpf.substring(0, 1).equals("")) {
			try {				
				int d1, d2;
				int digito1, digito2, resto;
				int digitoCPF;
				String nDigResult;
				strCpf = strCpf.replace('.', ' ');
				strCpf = strCpf.replace('-', ' ');
				strCpf = strCpf.replaceAll(" ", "");
				d1 = d2 = 0;
				digito1 = digito2 = resto = 0;

				for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
					digitoCPF = Integer.valueOf(
							strCpf.substring(nCount - 1, nCount)).intValue();
					d1 = d1 + (11 - nCount) * digitoCPF;
					d2 = d2 + (12 - nCount) * digitoCPF;
				}
				resto = (d1 % 11);
				if (resto < 2) {
					digito1 = 0;
				} else {
					digito1 = 11 - resto;
				}
				d2 += 2 * digito1;
				resto = (d2 % 11);
				if (resto < 2) {
					digito2 = 0;
				} else {
					digito2 = 11 - resto;
				}
				String nDigVerific = strCpf.substring(strCpf.length() - 2,
						strCpf.length());
				nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
				return nDigVerific.equals(nDigResult);
			} catch (Exception e) {
				System.err.println("Erro !" + e);
				return false;
			}
		} else {
			return false;
		}
	}

	/**Metodo get e set do atributo cpf*/
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

package com.facade;

import javax.ejb.Local;

@Local
public interface RevendedoraCpfFacede {

	public abstract Boolean  buscarCpf (String cpf);	
}

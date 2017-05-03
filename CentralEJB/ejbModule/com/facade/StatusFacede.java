package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Status;

@Local
public interface StatusFacede{
	
	abstract List<Status>  buscarStatus (Long tipoStatus);
	
}

package com.facade;

import javax.ejb.Local;

import com.model.HistoricoAtendimento;

@Local
public interface HistoricoAtendimentoFacede{

	public abstract void cadastrar(HistoricoAtendimento entity);
}

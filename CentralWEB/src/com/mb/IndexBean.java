package com.mb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.model.Catalogo;
import com.model.EstadoData;

public class IndexBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6861550588228384052L;
	
	
	public List<EstadoData> getListaUser(){
		List<EstadoData> lista = new ArrayList<EstadoData>();
		
		try {
		      
		      BufferedReader StrR = new BufferedReader(new FileReader(System.getProperty("user.home") + "/datas/datas.txt"));
	            String Str;
	            String[] TableLine;
	            while((Str = StrR.readLine())!= null){

	                TableLine = Str.split(":");
	                	EstadoData estado = new EstadoData();
	                	estado.setDsCidade(TableLine[0]);
	                	estado.setEntradaPedido(TableLine[1]);
	                	estado.setEntregaCaixa(TableLine[2]);
	                	estado.setBoletoPagamento(TableLine[3]);
	                	lista.add(estado); 
	                
	                System.out.println("\n");
	            }
	            StrR.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
		
			
		return lista;
	}
	
	
	public List<Catalogo> getListaCatalogo(){
		List<Catalogo> lista = new ArrayList<Catalogo>();
		
		try {
		      
		      BufferedReader StrR = new BufferedReader(new FileReader(System.getProperty("user.home") + "/catalogo.centraldarevendedora.com.br/catalogo/catalogo.txt"));
	            String Str;
	            String[] TableLine;
	            while((Str = StrR.readLine())!= null){

	                TableLine = Str.split(";");
	                Catalogo catalogo = new Catalogo();
	                catalogo.setCatNome(TableLine[0]);
	                catalogo.setCatNomeCatalogo(TableLine[1]);
	                catalogo.setCatPhoto(TableLine[2]);
	                catalogo.setCatUrl(TableLine[3]);
	                lista.add(catalogo); 
	                System.out.println("\n");
	            }
	            StrR.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
		
			
		return lista;
	}

	
}

package br.edu.unicid.bean;


import java.sql.Date;
import br.edu.unicid.annotation.DBTable;
import br.edu.unicid.annotation.DBField;

@DBTable(table="categorias")

public class Categoria  {
	@DBField(colummn="cod_categoria")
	private int cod_categoria;
	
	@DBField(colummn="nomeCategoria")
	private String nomeCategoria;
	
	@DBField(colummn="linhaCategoria")
	private String linhaCategoria;
	
	@DBField(colummn="faixaCategoria")
	private String faixaCategoria;
	
	

	public Categoria(int cod_categoria, String nomeCategoria, String linhaCategoria, String faixaCategoria) {
		this.cod_categoria = cod_categoria;
		this.nomeCategoria = nomeCategoria;
		this.linhaCategoria = linhaCategoria;
		this.faixaCategoria = faixaCategoria;
	}

	public Categoria() {
	}
	
	public int getCod_categoria() {
		return cod_categoria;
	}
	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getLinhaCategoria() {
		return linhaCategoria;
	}
	public void setLinhaCategoria(String linhaCategoria) {
		this.linhaCategoria = linhaCategoria;
	}
	public String getFaixaCategoria() {
		return faixaCategoria;
	}
	public void setFaixaCategoria(String faixaCategoria) {
		this.faixaCategoria = faixaCategoria;
	}
	
	
	
}

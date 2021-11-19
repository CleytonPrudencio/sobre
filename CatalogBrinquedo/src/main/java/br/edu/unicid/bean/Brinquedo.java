package br.edu.unicid.bean;



public class Brinquedo {
	private int cod_brinquedo;
	private String nomeBrinquedo;
	private double precoBrinquedo;
	private int categoria;
	private String imagemBrinquedo;
	private String descricaoBrinquedo;
	private String nomeCategoria;
	
	

	public Brinquedo(int cod_brinquedo, String nomeBrinquedo, double precoBrinquedo, int categoria,
			String descricaoBrinquedo, String imagemBrinquedo) {
		
		this.cod_brinquedo = cod_brinquedo;
		this.nomeBrinquedo = nomeBrinquedo;
		this.precoBrinquedo = precoBrinquedo;
		this.categoria = categoria;
		this.descricaoBrinquedo = descricaoBrinquedo;
		this.imagemBrinquedo = imagemBrinquedo;
	}
	
	public Brinquedo(int cod_brinquedo, String nomeBrinquedo, double precoBrinquedo, int categoria,
			String descricaoBrinquedo, String imagemBrinquedo, String nomeCategoria) {
		
		this.cod_brinquedo = cod_brinquedo;
		this.nomeBrinquedo = nomeBrinquedo;
		this.precoBrinquedo = precoBrinquedo;
		this.categoria = categoria;
		this.descricaoBrinquedo = descricaoBrinquedo;
		this.imagemBrinquedo = imagemBrinquedo;
		this.nomeCategoria = nomeCategoria;
	}
	
	
	public Brinquedo (int cod_brinquedo, String imagemBrinquedo) {
		this.cod_brinquedo = cod_brinquedo;
		this.imagemBrinquedo = imagemBrinquedo;
	}
	
	public Brinquedo() {
		
	}
	
	public int getCod_brinquedo() {
		return cod_brinquedo;
	}
	public void setCod_brinquedo(int cod_brinquedo) {
		this.cod_brinquedo = cod_brinquedo;
	}
	public String getNomeBrinquedo() {
		return nomeBrinquedo;
	}
	public void setNomeBrinquedo(String nomeBrinquedo) {
		this.nomeBrinquedo = nomeBrinquedo;
	}
	public double getPrecoBrinquedo() {
		return precoBrinquedo;
	}
	public void setPrecoBrinquedo(double precoBrinquedo) {
		this.precoBrinquedo = precoBrinquedo;
	}
	public int getNomeint() {
		return categoria;
	}
	public void setNomeint(int nomeint) {
		this.categoria = nomeint;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getDescricaoBrinquedo() {
		return descricaoBrinquedo;
	}
	public void setDescricaoBrinquedo(String descricaoBrinquedo) {
		this.descricaoBrinquedo = descricaoBrinquedo;
	}
	
	public String getImagemBrinquedo() {
		return imagemBrinquedo;
	}
	
	public void setImagemBrinquedo(String imagemBrinquedo) {
		this.imagemBrinquedo = imagemBrinquedo;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}

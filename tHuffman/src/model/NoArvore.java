package model;

public class NoArvore{
	
	private NoArvore pai;
	private NoArvore esquerdo;
	private NoArvore direito;
	
	private int frequencia;
	
	private boolean isNoDireito;
	private boolean isRaiz;
	private String codigo;
	private int identificador;
	
	public NoArvore(NoArvore pai, NoArvore esquerdo, NoArvore direito, int frequencia, int identificador){
		
		this.pai = pai;
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.frequencia = frequencia;
		codigo = "";
		this.identificador = identificador;
		
	}
	
	public NoArvore getPai(){
		return pai;
	}

	public void setPai(NoArvore pai){
		this.pai = pai;
	}

	public NoArvore getNoEsquerdo(){
		return esquerdo;
	}

	public void setNoEsquerdo(NoArvore esquerdo){
		this.esquerdo = esquerdo;
	}

	public NoArvore getNoDireito(){
		return direito;
	}

	public void setNoDireito(NoArvore direito){
		this.direito = direito;
	}

	public int getFrequencia(){
		return frequencia;		
	}
	
	public void setFrequencia(int frequencia){
		this.frequencia = frequencia;		
	}

	public boolean isNoDireito(){
		return isNoDireito;
	}

	public void setIsNoDireito(boolean isNoDireito){
		this.isNoDireito = isNoDireito;
	}
	
	public boolean isFolha(){
		
		return (esquerdo == null && direito == null);
		
	}	
	
	public boolean isRaiz(){
		return isRaiz;
	}

	public void setIsRaiz(boolean isRaiz){
		this.isRaiz = isRaiz;
	}

	public String getCodigo(){
		return codigo;		
	}
	
	public void setCodigo(String codigo){		
		this.codigo = codigo;	
	}
	
	public int getIdentificador(){
		return identificador;
	}

}

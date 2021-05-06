package model;

public class Codigo{
	
	//private byte valor;
	private byte nBits;
	private byte[] cod;
	
	public Codigo(byte nBits, int tam) {
		
		//this.valor = valor;
		this.nBits = nBits;
		this.cod = new byte[tam];

	}

	/*public byte getValor(){
		return valor;
	}

	public void setValor(byte valor){
		this.valor = valor;
	}*/

	public byte getnBits(){
		return nBits;
	}

	public byte getBitCod(int i){
		//System.out.print("Aqui");
		return cod[i];
	}

	public void setCod(byte cod, int j){
		this.cod[j] = cod;
		nBits++;
	}	
	
}

package estruturas;

public class Codigo{
	
	private byte nBits;
	private byte[] cod;
	
	public Codigo(byte nBits, int tam) {
		
		this.nBits = nBits;
		this.cod = new byte[tam];

	}

	public byte getnBits(){
		return nBits;
	}

	public byte getBitCod(int i){
		return cod[i];
	}

	public void setCod(byte cod, int j){
		this.cod[j] = cod;
		nBits++;
	}	
	
}

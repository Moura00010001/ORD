package grafos;

public class Vertice{
	
	private int identificador;
	private int distancia;
	private String pi;
	private int posHeap;
	
	public Vertice(int id){
		
		identificador = id;
		
	}
	
	public Vertice(int id, int d, String pi){
		
		identificador = id;
		distancia = d;
		this.pi = pi;
		
	}
	
	public int getIdentificador(){
		return identificador;
	}
	
	public int getDistancia(){
		return distancia;
	}
	
	public void setDistancia(int d){
		distancia = d;
	}
	
	public String getPi(){
		return pi;
	}	
	
	public void setPi(String pi){
		this.pi = pi;
	}
	
	public int getPosHeap(){
		return posHeap;
	}
	
	public void setPosHeap(int posHeap){
		this.posHeap = posHeap;
	}
	
}

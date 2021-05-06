package main;

import algoritmos.Dijkstra;
import model.Grafo;
import model.Vertice;

public class Main{
	
	public static void main(String[] args){
		
		Grafo grafo = new Grafo("dij50");
				
		Dijkstra d = new Dijkstra();
		d.algoritmoDijkstra(grafo, new Vertice(0));

	}

}

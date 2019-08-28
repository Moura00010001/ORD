package algoritmos;

import java.util.ArrayList;
import java.util.Stack;

import grafos.Grafo;
import grafos.Vertice;
import heaps.HeapDijkstra;

public class Dijkstra{
	
	private Stack<Vertice> pilha;
	
	public Dijkstra(){
		
		pilha = new Stack<Vertice>();
		
	}
	
	private void inicializar(Grafo g, Vertice verticeS){
		
		g.inicializarArrayVertices(verticeS.getIdentificador());
				
	}
	
	private void relax(Vertice verticeInicial, Vertice vAdjacente, int pesoAresta, HeapDijkstra heap){
		
		if(vAdjacente.getDistancia() > verticeInicial.getDistancia() + pesoAresta){
		
			vAdjacente.setDistancia(verticeInicial.getDistancia() + pesoAresta);
			vAdjacente.setPi("V" + verticeInicial.getIdentificador());
			
			// Atualiza o heap com poss�veis novas informa��es da lista de adjac�ncia
			heap.getVetor()[vAdjacente.getPosHeap()].setPi("V" + verticeInicial.getIdentificador());
			heap.MinHeapDecreaseKey(heap, vAdjacente.getPosHeap(), vAdjacente);
		
		}
		
	}
	
	public void algoritmoDijkstra(Grafo g, Vertice verticeS){
		
		////////////////////////////////////////////////////////////////
		////////////////////////// Algoritmo //////////////////////////
		
		inicializar(g, verticeS);
		
		HeapDijkstra heap = new HeapDijkstra(g.getVertices(), g.getListaAdjacencia(), g.getTotalVertices());
		
		while(heap.getNElementos() != 0){
			
			Vertice u = heap.HeapExtractMin(heap);
			pilha.push(u);
			
			int nVizinhos = g.getListaAdjacencia().get(u.getIdentificador()).size();
			
			for(int i = 0; i < nVizinhos; i++)
				relax(u, g.getListaAdjacencia().get(u.getIdentificador()).get(i), g.getPesoAresta(u.getIdentificador(), g.getListaAdjacencia().get(u.getIdentificador()).get(i).getIdentificador()), heap);							
			
		}
		
		////////////////////////////////////////////////////////////////
		// Parte do c�digo apenas para mostrar resultados no terminal //
		
		int comprimento = heap.getComprimento();
		
		// Pilha auxiliar para guardar os valores do maior caminho at� u		
		Stack<Vertice> pilha2 = new Stack<Vertice>();
		for(int j = comprimento - 1; j >= 0; j--)
			pilha2.push(heap.getVetor()[j]);
		
		// Exibi��o de informa��es sobre o menor caminho 		
		for(int i = 0; i < comprimento; i ++)			
			if(heap.getVetor()[i].getIdentificador() == comprimento - 1){
				System.out.print("Menor caminho de u = 0 at� v = n - 1: " + heap.getVetor()[i].getDistancia());
				break;
			}

		System.out.println();
		System.out.println();
		System.out.print("Menor caminho de v = n - 1 at� u = 0: ");
		
		ArrayList<String> caminho = new ArrayList<String>();
				
		for(int j = pilha.size(); j > 0; j--){
			
			if(pilha.lastElement().getIdentificador() == comprimento - 1){
				
				Vertice v = pilha.pop();
				
				caminho.add(new String("V" + v.getIdentificador() + " "));
				caminho.add(new String(v.getPi() + " "));
				//System.out.print("V" + v.getIdentificador() + " " + v.getPi() + " ");
				
				if(v.getPi().equals("V0"))
					break;
				
				while(!pilha.isEmpty()){
					
					Vertice v2 = pilha.pop();
					
					if(!("V" + v2.getIdentificador()).equals(v.getPi()))
						continue;
					
					v = v2;
					caminho.add(new String(v.getPi() + " "));
					//System.out.print(v.getPi() + " ");
					
					if(v.getPi().equals("V0"))
						break;
					
				}				
				
				break;
			}
			
			pilha.pop();
		}
		
		for(int i = caminho.size() - 1; i >= 0; i--){
			
			System.out.print(caminho.get(i));
			
		}
		
		caminho.clear();
					
		// Exibi��o de informa��es sobre o maior caminho	
		System.out.println();
		System.out.println();
		System.out.print("Maior caminho at� u = 0: " + heap.getVetor()[0].getDistancia());
		
		System.out.println();
		System.out.println();
		System.out.print("Maior caminho at� u = 0: ");
				
		Vertice v = pilha2.pop();
				
		caminho.add(new String("V" + v.getIdentificador() + " "));
		caminho.add(new String(v.getPi() + " "));
		//System.out.print("V" + v.getIdentificador() + " " + v.getPi() + " ");
		
		if(v.getPi().equals("V0"))
			return;
				
		while(!pilha2.isEmpty()){
					
			Vertice v2 = pilha2.pop();
					
			if(!("V" + v2.getIdentificador()).equals(v.getPi()))
				continue;
					
			v = v2;
			caminho.add(new String(v.getPi() + " "));
			//System.out.print(v.getPi() + " ");
					
			if(v.getPi().equals("V0"))
				break;
					
		}	
		
		for(int j = caminho.size() - 1; j >= 0; j--){
			
			System.out.print(caminho.get(j));
			
		}		
	
	}

}
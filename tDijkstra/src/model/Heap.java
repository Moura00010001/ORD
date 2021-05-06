package model;

import java.util.ArrayList;
import java.util.List;

public class Heap{
	
	private Vertice[] vetor;
	private int tamanho;
	private int nElementos;
	private int comprimento;
	
	public Heap(ArrayList<Vertice> vetor, int nElementos){
		
		this.vetor = new Vertice[comprimento = vetor.size()];
		tamanho = this.nElementos = nElementos;
		
		for(int i = 0; i < nElementos; i++){
			
			this.vetor[i] = vetor.get(i);
			this.vetor[i].setPosHeap(i);
		
		}
		
	}
	
	public Heap(ArrayList<Vertice> vetor, List<ArrayList<Vertice>> listaAdjacencia, int nElementos){
		
		this.vetor = new Vertice[comprimento = vetor.size()];
		tamanho = this.nElementos = nElementos;
		
		for(int i = 0; i < nElementos; i++){
			
			this.vetor[i] = vetor.get(i);
			this.vetor[i].setPosHeap(i);
		
		}
		
		int tamLista = listaAdjacencia.size();
		//int nVizinhos = listaAdjacencia.get(0).size();
		
        for(int i = 0; i < tamLista; i++){
    		
    		for(int j = 0; j < tamLista; j++){
    			
    			if(i == j){
    				
    				continue;
    				
    			}      			
    			
    			listaAdjacencia.get(i).add(this.vetor[j]);
    			
    		}        		
    		
    	}				
	}	
	
	public Vertice[] getVetor(){
		return vetor;
	}
	
	public void setValorVetor(int posicao, Vertice valor){
		vetor[posicao].setDistancia(valor.getDistancia());		
	}
	
	public int getNElementos(){
		return nElementos;
	}
	
	public int getComprimento(){
		return comprimento;
	}
	
	public void trocarValores(int posOrigem, int posDestino){
		
		Vertice aux = vetor[posOrigem];
		
		vetor[posOrigem] = vetor[posDestino];
		vetor[posOrigem].setPosHeap(posOrigem);
		
		vetor[posDestino] = aux;
		vetor[posDestino].setPosHeap(posDestino);
		
	}
	
	public void exibirValores(Heap heap){
		
		System.out.println();
		System.out.println("Situação atual do heap:");
		
	    if(nElementos < 1)
	    	System.out.println("NULL");
	    
	    else{
	    	
			for(int i = 0; i < nElementos; i++)
		    	System.out.print(vetor[i] + " ");
	    
			System.out.println();
	    	
	    }
		
	}

	public int Pai(Heap heap, int i){

	    if(i == 0)
	    	return -1;
	    
	    else
	    	return (int) (i-1)/2;
	    
	}
	
	public int FilhoDir(Heap heap, int i){

	    if(2*i + 2 < comprimento)
	    	return 2*i + 2;
	    else
	    	return -1;
	    
	}

	public int FilhoEsq(Heap heap, int i){
		
		if(2*i + 1 < comprimento)
			return 2*i + 1;
		
		else
			return -1;
	    
	}
	
	public void MaxHeapify(Heap heap, int i){

	    int direito = FilhoDir(heap, i);
	    int esquerdo = FilhoEsq(heap, i);
	    int maior = 0;
	    
	    if(esquerdo == -1 )
	    	;
	    else if(esquerdo < tamanho && vetor[esquerdo].getDistancia() > vetor[i].getDistancia())
	        maior = esquerdo;
	    else
	        maior = i;

	    if(direito == -1)
	    	;
	    else if(direito < tamanho && vetor[direito].getDistancia() > vetor[maior].getDistancia())
	        maior = direito;

	    if(maior != i && (direito != -1 || esquerdo != -1)){

	        trocarValores(i, maior);

	        MaxHeapify(heap, maior);

	    }

	}
	
	public void MinHeapify(Heap heap, int i){

	    int direito = FilhoDir(heap, i);
	    int esquerdo = FilhoEsq(heap, i);
	    int menor = 0;
	    
	    if(esquerdo == -1 )
	    	;
	    else if(esquerdo < tamanho && vetor[esquerdo].getDistancia() < vetor[i].getDistancia())
	        menor = esquerdo;
	    else
	        menor = i;

	    if(direito == -1)
	    	;
	    else if(direito < tamanho && vetor[direito].getDistancia() < vetor[menor].getDistancia())
	        menor = direito;

	    if(menor != i && (direito != -1 || esquerdo != -1)){

	        trocarValores(i, menor);

	        MinHeapify(heap, menor);

	    }

	}

	public void BuildMaxHeap(Heap heap){

	    tamanho = nElementos;

	    for(int i = (int) (nElementos/2) - 1; i >= 0; i--)
	        MaxHeapify(heap, i);

	}
	
	public void BuildMinHeap(Heap heap){

	    tamanho = nElementos;

	    for(int i = (int) (nElementos/2) - 1; i >= 0; i--)
	        MinHeapify(heap, i);

	}
	
	public void HeapSort(Heap heap){
		
		//BuildMaxHeap(heap);
		BuildMinHeap(heap);
		
		for(int i = nElementos - 1; i > 0; i--){

	        trocarValores(0, i);
	        
	        tamanho--;
	        
	        //MaxHeapify(heap, 0);
	        MinHeapify(heap, 0);
			
		}
		
	}
	
	public Vertice HeapMaximun(Heap heap){
		
		return vetor[0];
		
	}
	
	public Vertice HeapMinimun(Heap heap){
		
		return vetor[0];
		
	}
	
	public Vertice HeapExtractMax(Heap heap){
		
		if(nElementos < 1){
			
			System.out.println();
			System.out.println("Não há mais elementos a serem removidos.");
			return null;
			
		}	
		
		Vertice elementoRemovido = HeapMaximun(heap);

        trocarValores(0, nElementos - 1);
        
        tamanho--;
        nElementos--;
        
        MaxHeapify(heap, 0);
        
        return elementoRemovido;
        
	}
	
	public Vertice HeapExtractMin(Heap heap){
		
		if(nElementos < 1){
			
			System.out.println();
			System.out.println("Não há mais elementos a serem removidos.");
			return null;
			
		}
		
		Vertice elementoRemovido = HeapMinimun(heap);

        trocarValores(0, nElementos - 1);
        
        tamanho--;
        nElementos--;
        
        MinHeapify(heap, 0);
        
        return elementoRemovido;
        
	}
	
	public void MaxHeapIncreaseKey(Heap heap, int i, Vertice chave){
		
		if(chave.getDistancia() < vetor[i].getDistancia()){
			
			System.out.println();
			System.out.println("Chave menor que elemento atual. Não acontecerá nada.");
			return;
			
		}
		
		heap.setValorVetor(i, chave);
		
		while(i > 0 && vetor[heap.Pai(heap, i)].getDistancia() < vetor[i].getDistancia()){
			
			trocarValores(i, heap.Pai(heap, i));
			i = heap.Pai(heap, i);
			
		}
		
	}
	
	public void MinHeapIncreaseKey(Heap heap, int i, Vertice chave){
		
		if(chave.getDistancia() < vetor[i].getDistancia()){
			
			System.out.println();
			System.out.println("Chave menor que elemento atual. Não acontecerá nada.");
			return;
			
		}
		
		heap.setValorVetor(nElementos, chave);
		
		while(i < 0 && vetor[heap.Pai(heap, i)].getDistancia() > vetor[i].getDistancia()){
			
			trocarValores(i, heap.Pai(heap, i));
			i = heap.Pai(heap, i);
			
		}
		
	}
	
	public void MinHeapDecreaseKey(Heap heap, int i, Vertice chave){
		
		if(chave.getDistancia() > vetor[i].getDistancia()){
			
			System.out.println();
			System.out.println("Chave maior que elemento atual. Não acontecerá nada.");
			return;
			
		}
		
		heap.setValorVetor(i, chave);
		
		while(i > 0 && vetor[heap.Pai(heap, i)].getDistancia() > vetor[i].getDistancia()){
			
			trocarValores(i, heap.Pai(heap, i));
			i = heap.Pai(heap, i);
						
		}
		
	}
	
	public void MaxHeapInsert(Heap heap, int chave){
		
		if(nElementos == comprimento){
			
			System.out.println();
			System.out.println("Heap cheio. Novos elementos não podem ser inseridos.");
			return;
			
		}
		
		tamanho++;
		nElementos++;
				
		heap.setValorVetor(nElementos - 1, new Vertice(nElementos, (int) Double.NEGATIVE_INFINITY, null));
		
		heap.MaxHeapIncreaseKey(heap, nElementos - 1, new Vertice(nElementos, chave, null));
		
	}	
	
	public void MinHeapInsert(Heap heap, int chave){
		
		if(nElementos == comprimento){
			
			System.out.println();
			System.out.println("Heap cheio. Novos elementos não podem ser inseridos.");
			return;
			
		}
		
		tamanho++;
		nElementos++;
				
		heap.setValorVetor(nElementos - 1, new Vertice(nElementos, (int) Double.POSITIVE_INFINITY, null));
		
		heap.MinHeapIncreaseKey(heap, nElementos - 1, new Vertice(nElementos, chave, null));
		
	}	

}


package model;

import java.util.ArrayList;

public class HeapHuffman{
	
	private NoArvore[] vetor;
	private int posNos;
	private int tamanho;
	private int nElementos;
	private int comprimento;
	
	public HeapHuffman(ArrayList<NoArvore> vetorFrequencia){
		
		this.vetor = new NoArvore[posNos = comprimento = 2 * vetorFrequencia.size()];
		posNos--;
		tamanho = nElementos = vetorFrequencia.size();
		
		for(int i = 0; i < nElementos; i++){
			
			//if(vetorFrequencia[i] == 0)
			//	continue;
			
			vetor[i] = vetorFrequencia.get(i);
			//vetor[i] = new NoArvore(null, null, null, vetorFrequencia.get(i), i);
			
		}	
		
	}
	
	/*public HeapHuffman(int[] vetorFrequencia){
		
		this.vetor = new NoArvore[posNos = comprimento = 2 * vetorFrequencia.length];
		posNos--;
		//tamanho = nElementos = vetorFrequencia.length;
		
		for(int i = 0, j = 0; i < vetorFrequencia.length; i++){
			
			if(vetorFrequencia[i] != 0){
				
				vetor[j] = new NoArvore(null, null, null, vetorFrequencia[i], i);
				++j;
				++tamanho;
				++nElementos;
			
			}
			
		}	
		
	}*/
	
	public NoArvore[] getVetor(){
		return vetor;
	}
	
	public void setValorVetor(int posicao, NoArvore no){
		vetor[posicao] = no;		
	}
	
	public int getNElementos(){
		return nElementos;
	}
	
	public int getComprimento(){
		return comprimento;
	}
	
	public void trocarValores(int posOrigem, int posDestino){
		
		NoArvore aux = vetor[posOrigem];
		
		vetor[posOrigem] = vetor[posDestino];
		//vetor[posOrigem].setPosHeap(posOrigem);
		
		vetor[posDestino] = aux;
		//vetor[posDestino].setPosHeap(posDestino);
		
	}
	
	public void exibirValores(HeapHuffman heap){
		
		System.out.println();
		System.out.println("Situação atual do heap:");
		
	    if(nElementos < 1)
	    	System.out.println("NULL");
	    
	    else{
	    	
			for(int i = 0; i < nElementos; i++)
		    	System.out.println(vetor[i].getCodigo() + " ");
	    
			System.out.println();
	    	
	    }
		
	}

	public int Pai(HeapHuffman heap, int i){

	    if(i == 0)
	    	return -1;
	    
	    else
	    	return (int) (i-1)/2;
	    
	}
	
	public int FilhoDir(HeapHuffman heap, int i){

	    if(2*i + 2 < comprimento)
	    	return 2*i + 2;
	    else
	    	return -1;
	    
	}

	public int FilhoEsq(HeapHuffman heap, int i){
		
		if(2*i + 1 < comprimento)
			return 2*i + 1;
		
		else
			return -1;
	    
	}
	
	public void MaxHeapify(HeapHuffman heap, int i){

	    int direito = FilhoDir(heap, i);
	    int esquerdo = FilhoEsq(heap, i);
	    int maior = 0;
	    
	    if(esquerdo == -1 )
	    	;
	    else if(esquerdo < tamanho && vetor[esquerdo].getFrequencia() > vetor[i].getFrequencia())
	        maior = esquerdo;
	    else
	        maior = i;

	    if(direito == -1)
	    	;
	    else if(direito < tamanho && vetor[direito].getFrequencia() > vetor[maior].getFrequencia())
	        maior = direito;

	    if(maior != i && (direito != -1 || esquerdo != -1)){

	        trocarValores(i, maior);

	        MaxHeapify(heap, maior);

	    }

	}
	
	public void MinHeapify(HeapHuffman heap, int i){

	    int direito = FilhoDir(heap, i);
	    int esquerdo = FilhoEsq(heap, i);
	    int menor = 0;
	    
	    if(esquerdo == -1 )
	    	;
	    else if(esquerdo < tamanho && vetor[esquerdo].getFrequencia() < vetor[i].getFrequencia())
	        menor = esquerdo;
	    else
	        menor = i;

	    if(direito == -1)
	    	;
	    else if(direito < tamanho && vetor[direito].getFrequencia() < vetor[menor].getFrequencia())
	        menor = direito;

	    if(menor != i && (direito != -1 || esquerdo != -1)){

	        trocarValores(i, menor);

	        MinHeapify(heap, menor);

	    }

	}

	public void BuildMaxHeap(HeapHuffman heap){

	    tamanho = nElementos;

	    for(int i = (int) (nElementos/2) - 1; i >= 0; i--)
	        MaxHeapify(heap, i);

	}
	
	public void BuildMinHeap(HeapHuffman heap){

	    tamanho = nElementos;

	    for(int i = (int) (nElementos/2) - 1; i >= 0; i--)
	        MinHeapify(heap, i);

	}
	
	public void HeapSort(HeapHuffman heap){
		
		//BuildMaxHeap(heap);
		BuildMinHeap(heap);
		
		for(int i = nElementos - 1; i > 0; i--){

	        trocarValores(0, i);
	        
	        tamanho--;
	        
	        //MaxHeapify(heap, 0);
	        MinHeapify(heap, 0);
			
		}
		
	}
	
	public NoArvore HeapMaximun(){
		
		return vetor[0];
		
	}
	
	public NoArvore HeapMinimun(){
		
		return vetor[0];
		
	}
	
	public NoArvore HeapExtractMax(HeapHuffman heap){
		
		if(nElementos < 1){
			
			System.out.println();
			System.out.println("Não há mais elementos a serem removidos.");
			return null;
			
		}	
		
		NoArvore elementoRemovido = HeapMaximun();

        trocarValores(0, nElementos - 1);
        
        tamanho--;
        nElementos--;
        
        MaxHeapify(heap, 0);
        
        return elementoRemovido;
        
	}
	
	public NoArvore HeapExtractMin(HeapHuffman heap){
		
		if(nElementos < 1){
			
			System.out.println();
			System.out.println("Não há mais elementos a serem removidos.");
			return null;
			
		}
		
		NoArvore elementoRemovido = HeapMinimun();

        trocarValores(0, nElementos - 1);
        trocarValores(nElementos - 1, --posNos);
        
        tamanho--;
        nElementos--;
        
        MinHeapify(heap, 0);
        
        return elementoRemovido;
        
	}
	
	public void MaxHeapIncreaseKey(HeapHuffman heap, int i, NoArvore chave){
		
		if(chave.getFrequencia() < vetor[i].getFrequencia()){
			
			System.out.println();
			System.out.println("Chave menor que elemento atual. Não acontecerá nada.");
			return;
			
		}
		
		heap.setValorVetor(i, chave);
		
		while(i > 0 && vetor[heap.Pai(heap, i)].getFrequencia() < vetor[i].getFrequencia()){
			
			trocarValores(i, heap.Pai(heap, i));
			i = heap.Pai(heap, i);
			
		}
		
	}
	
	public void MinHeapIncreaseKey(HeapHuffman heap, int i, NoArvore chave){
		
		if(chave.getFrequencia() > vetor[i].getFrequencia()){
			
			System.out.println();
			System.out.println("Chave menor que elemento atual. Não acontecerá nada.");
			return;
			
		}
		
		heap.setValorVetor(i, chave);
		
		while(i > 0 && vetor[heap.Pai(heap, i)].getFrequencia() > vetor[i].getFrequencia()){
			
			trocarValores(i, heap.Pai(heap, i));
			i = heap.Pai(heap, i);
			
		}
		
	}
	
	public void MinHeapDecreaseKey(HeapHuffman heap, int i, NoArvore chave){
		
		if(chave.getFrequencia() > vetor[i].getFrequencia()){
			
			System.out.println();
			System.out.println("Chave maior que elemento atual. Não acontecerá nada.");
			return;
			
		}
		
		heap.setValorVetor(i, chave);
		
		while(i > 0 && vetor[heap.Pai(heap, i)].getFrequencia() > vetor[i].getFrequencia()){
			
			trocarValores(i, heap.Pai(heap, i));
			i = heap.Pai(heap, i);
						
		}
		
	}
	
	public void MaxHeapInsert(HeapHuffman heap, int chave){
		
		if(nElementos == comprimento){
			
			System.out.println();
			System.out.println("Heap cheio. Novos elementos não podem ser inseridos.");
			return;
			
		}
		
		tamanho++;
		nElementos++;
				
		heap.setValorVetor(nElementos - 1, new NoArvore(null, null, null, (int) Double.NEGATIVE_INFINITY, 999999));
		
		heap.MaxHeapIncreaseKey(heap, nElementos - 1, new NoArvore(null, null, null, chave, 999999));
		
	}	
	
	public void MinHeapInsert(HeapHuffman heap, NoArvore chave){
		
		if(nElementos == comprimento){
			
			System.out.println();
			System.out.println("Heap cheio. Novos elementos não podem ser inseridos.");
			return;
			
		}
		
		tamanho++;
		nElementos++;
				
		heap.setValorVetor(nElementos - 1, new NoArvore(null, null, null, (int) Double.POSITIVE_INFINITY, 999999));
		
		heap.MinHeapIncreaseKey(heap, nElementos - 1, chave);
		
	}	

}



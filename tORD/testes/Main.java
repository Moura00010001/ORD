package testes;

import java.util.ArrayList;

import algoritmos.CountingSort;
import algoritmos.Dijkstra;
import algoritmos.Huffman;
import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import algoritmos.QuickSort;
import algoritmos.RadixSort;
import algoritmos.SelectionSort;
import estruturas.Codigo;
import grafos.Grafo;
import grafos.Vertice;
import heaps.HeapHuffman;
import leitores.RWHuffman;
import nodes.NoArvore;

public class Main{
	
	public static void main(String[] args){
		
		//Grafo grafo = new Grafo("dij50");
				
		//Dijkstra d = new Dijkstra();
		//d.algoritmoDijkstra(grafo, new Vertice(0));
		
		/*
		//int[] vetorFrequencia = RWHuffman.carregarArquivoParaVetorFrequencia("generated.equal");
		//int[] vetorFrequencia = RWHuffman.carregarArquivoParaVetorFrequencia("generated.fib25");
		int[] vetorFrequencia = RWHuffman.carregarArquivoParaVetorFrequencia("dragonforce.txt");
		
		//int[] vetorFrequencia2 = {1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 8, 12};
		
		 ArrayList<Integer> vetor = new ArrayList<Integer>();
		 ArrayList<NoArvore> v = new ArrayList<NoArvore>();
		 
		 for(int j = 0; j < vetorFrequencia.length; j++){
			 
			 if(vetorFrequencia[j] == 0)
				 continue;
		
			 vetor.add(vetorFrequencia[j]);
			 v.add(new NoArvore(null, null, null, vetorFrequencia[j], j));
			 
		 }
		
		HeapHuffman minHeap = Huffman.construirArvore(v);
		
		Huffman huffman = new Huffman();
		 
		ArrayList<String> codigos = new ArrayList<String>();
		ArrayList<Codigo> cods = new ArrayList<Codigo>();
		
		for(int j = 0; j < vetorFrequencia.length; j++)
			cods.add(new Codigo((byte) 0, 50));
		
		for(int i = minHeap.getComprimento() - 1; i > 0; i--){
			
			if(minHeap.getVetor()[i] != null && minHeap.getVetor()[i].isFolha()){
				
				System.out.print("Caracter " + minHeap.getVetor()[i].getIdentificador()  + " | " + "Código: ");

				//huffman.gerarExibirCodigos(minHeap, minHeap.getVetor()[i], 0, minHeap.getVetor()[i].getIdentificador(), cods);
				huffman.gerarExibirCodigos(minHeap, minHeap.getVetor()[i], 0, minHeap.getVetor()[i].getIdentificador(), cods);
				minHeap.getVetor()[i].setCodigo(huffman.getCodigo());
				codigos.add(new String(huffman.getCodigo()));
				
				for(int j = 0, k = huffman.getCodigo().length() - 1; j < huffman.getCodigo().length(); j++){
					
					if(huffman.getCodigo().charAt(j) == '0')
						cods.get(minHeap.getVetor()[i].getIdentificador()).setCod((byte) 0, k);
					
					else
						cods.get(minHeap.getVetor()[i].getIdentificador()).setCod((byte) 1, k);
					
					k--;
					
				}	
				
				huffman.setCodigo("");
				System.out.println();
				
			}	
			

		}	
		
		//RWHuffman.codificarArquivo("generated.equal", "generatedCod.txt", cods, vetorFrequencia);
		//RWHuffman.decodificarArquivo("generatedCod.txt", "generatedDecod.txt");
		
		//RWHuffman.codificarArquivo("generated.fib25", "generatedCod.fib25", cods, vetorFrequencia);
		//RWHuffman.decodificarArquivo("generatedCod.fib25", "generatedDecod.fib25");
		
		RWHuffman.codificarArquivo("dragonforce.txt", "dragonforceCod.txt", cods, vetorFrequencia);
		RWHuffman.decodificarArquivo("dragonforceCod.txt", "dragonforceDecod.txt");
		
		System.out.println("Finish!");
		*/
		
		CountingSort cs = new CountingSort("couting.txt");
		CountingSort cs2 = new CountingSort("num.1000.1.in");
		RadixSort rs = new RadixSort("num.1000.1.in");
		InsertionSort is = new InsertionSort("num.1000.1.in");
		SelectionSort ss = new SelectionSort("num.1000.1.in");
		MergeSort ms = new MergeSort("num.1000.1.in");
		QuickSort qs = new QuickSort("num.1000.1.in");
		
		long[] A = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17}, B = null;		
		long[] C = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};
		
		B = CountingSort.algoritmoCountingSort(A);
		InsertionSort.algoritmoInsertionSort(A);
		RadixSort.algoritmoRadixSort(C);
				
		long D[] = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};		
		SelectionSort.algoritmoSelectionSort(D);
		
		long E[] = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};
		MergeSort.algoritmoMergeSort(E, 0, E.length - 1);
		
		long F[] = {15, 0, 3, 4, 17, 12, 1, 0, 5, 17, 2, 7, 6, 8, 0, 16, 4, 17, -50, -7, 5, -1, 17};
		QuickSort.algoritmoQuickSort2(F, 0, F.length - 1);
		
		CountingSort cs3 = new CountingSort("num.10000.4.in");
		RadixSort rs2 = new RadixSort("num.100000.4.in");
		InsertionSort is2 = new InsertionSort("num.100000.4.in");
		SelectionSort ss2 = new SelectionSort("num.100000.4.in");
		MergeSort ms2 = new MergeSort("num.100000.4.in");
		QuickSort qs2 = new QuickSort("num.100000.4.in");
				
		System.out.println("Finish!");

	}

}

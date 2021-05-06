package main;

import java.util.ArrayList;

import algoritmos.Huffman;
import infra.RWHuffman;
import model.Codigo;
import model.HeapHuffman;
import model.NoArvore;

public class Main{
	
	public static void main(String[] args){
		
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

	}

}

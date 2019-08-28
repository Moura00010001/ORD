package algoritmos;

import java.util.ArrayList;

import estruturas.Codigo;
import heaps.HeapHuffman;
import nodes.NoArvore;

public class Huffman{
	
	private String codigo = "";
	
	public static HeapHuffman construirArvore(ArrayList<NoArvore> vetorFrequencia){
		
		NoArvore esquerdo, direito, pai;
		
		HeapHuffman heap = new HeapHuffman(vetorFrequencia);
		
		while(heap.getNElementos() > 1){
			
			esquerdo = heap.HeapExtractMin(heap);
			esquerdo.setIsNoDireito(false);			
			direito = heap.HeapExtractMin(heap);
			direito.setIsNoDireito(true);
			
			int frequenciaPai = esquerdo.getFrequencia() + direito.getFrequencia();
			
			pai = new NoArvore(null, esquerdo, direito, frequenciaPai, 999999);			
			esquerdo.setPai(pai);
			direito.setPai(pai);
			
			heap.MinHeapInsert(heap, pai);
			
		}
		
		heap.getVetor()[0].setIsRaiz(true);
		
		return heap;
		
	}
	
	public void gerarExibirCodigos(HeapHuffman heap, NoArvore no, int cont, int nNo, ArrayList<Codigo> cods){
		
		if(no.isNoDireito() && no.isRaiz() == false){
			
			codigo += "1";
			System.out.print(1);
			//cods.get(nNo).setCod((byte) 1, cont);
			
			gerarExibirCodigos(heap, no.getPai(), ++cont, nNo, cods);
			
		} 
		
		if(no.isNoDireito() == false && no.isRaiz() == false){
			
			codigo += "0";
			System.out.print(0);
			//cods.get(nNo).setCod((byte) 0, cont);

			gerarExibirCodigos(heap, no.getPai(), ++cont, nNo, cods);
			
		}
		
		if(no.isRaiz())
			return;
		
	}

	public String getCodigo(){
		return codigo;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

}

package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort{
	
	private static final String DIRETORIO = "recursos/";
	
	private long[] arr;	
	
	public MergeSort(String nomeArquivo){
		carregarArquivoParaVetor(nomeArquivo);
		algoritmoMergeSort(0, arr.length - 1);
	}
	
	public void carregarArquivoParaVetor(String nomeArquivo){
		
		FileReader isr = null;
        File txtFile = new File(DIRETORIO + nomeArquivo);
        try{
            isr = new FileReader(txtFile);
        } catch(FileNotFoundException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }
        
        BufferedReader reader = new BufferedReader(isr);
        
		String linha;
		int i = 0, mult, value;
		        
        try{
        	
        	linha = reader.readLine();
       	
          	value = (int) Integer.valueOf(linha);
           	
           	arr = new long[value];
        	
        	while(true){
        		
        		linha = reader.readLine();
        		
        		if(linha == null)
        			break;
	            		
           		String[] linhaAtual = linha.split("-");
	            		
           		mult = 1;
           		
           		for(int j = 0; j < linhaAtual.length; j++){
           			           			           			
           			if(linhaAtual[j].equals("")){
           				mult = -1;
           				continue;
           			}		
           			
        			arr[i] = Long.valueOf(linhaAtual[j]) * mult;
           			
           			i++;           			
           		}	
           		
        	}
        	
            reader.close();
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }
		
	}
	
	private void merge1(int iniEsq, int iniDir, int finalDir){
		
		int i, finalEsq, nElementos, posAux;
		finalEsq = iniDir - 1;
		posAux = 0;
		nElementos = finalDir - iniEsq + 1;
		
		long[] aux = new long[nElementos];
			
		/* Intercala as duas metades e coloca o resultado na tabela auxiliar */
		while((iniEsq <= finalEsq) && (iniDir <= finalDir))
			if(arr[iniEsq] <= arr[iniDir])
				aux[posAux++] = arr[iniEsq++];
			else
				aux[posAux++] = arr[iniDir++];
		
		/* Copia o restante da primeira metade */
		while(iniEsq <= finalEsq)
			aux[posAux++] = arr[iniEsq++];
		
		/* Copia o restante da segunda metade */
		while(iniDir <= finalDir)
			aux[posAux++] = arr[iniDir++];
		
		/* Copia o conteúdo do array auxiliar de */
		/* volta no array original */
		for(i = 0; i < nElementos; i++,finalDir--)
			arr[finalDir] = aux[--posAux];
		
	}
	
	private static void merge2(long[] A, int iniEsq, int iniDir, int finalDir){
		
		int i, finalEsq, nElementos, posAux;
		finalEsq = iniDir - 1;
		posAux = 0;
		nElementos = finalDir - iniEsq + 1;
		
		long[] aux = new long[nElementos];
			
		/* Intercala as duas metades e coloca o resultado na tabela auxiliar */
		while((iniEsq <= finalEsq) && (iniDir <= finalDir))
			if(A[iniEsq] <= A[iniDir])
				aux[posAux++] = A[iniEsq++];
			else
				aux[posAux++] = A[iniDir++];
		
		/* Copia o restante da primeira metade */
		while(iniEsq <= finalEsq)
			aux[posAux++] = A[iniEsq++];
		
		/* Copia o restante da segunda metade */
		while(iniDir <= finalDir)
			aux[posAux++] = A[iniDir++];
		
		/* Copia o conteúdo do array auxiliar de */
		/* volta no array original */
		for(i = 0; i < nElementos; i++,finalDir--)
			A[finalDir] = aux[--posAux];
		
	}
	
	private void algoritmoMergeSort(int iniEsq, int finalDir){
		
		if(iniEsq < finalDir){
			
			int mediana = (int) (iniEsq + finalDir) / 2;
			
			algoritmoMergeSort(iniEsq, mediana);
			algoritmoMergeSort(mediana + 1, finalDir);
			
			merge1(iniEsq, mediana + 1, finalDir);
			
		}
		
	}
	
	public static void algoritmoMergeSort(long[] A, int iniEsq, int finalDir){
		
		if(iniEsq < finalDir){
			
			int mediana = (int) (iniEsq + finalDir) / 2;
			
			algoritmoMergeSort(A, iniEsq, mediana);
			algoritmoMergeSort(A, mediana + 1, finalDir);
			
			MergeSort.merge2(A, iniEsq, mediana + 1, finalDir);
			
		}
		
	}

}

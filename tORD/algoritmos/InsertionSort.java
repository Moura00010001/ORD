package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort{
	
	private static final String DIRETORIO = "recursos/";
	
	private long[] arr;	
	
	public InsertionSort(String nomeArquivo){
		carregarArquivoParaVetor(nomeArquivo);
		algoritmoInsertionSort();
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
	
	private void algoritmoInsertionSort(){
		
		int i, j;
		long aux;

		for(i = 1; i < arr.length; i++){
			
			aux = arr[i];
			
			for(j = i - 1; j >= 0 && aux < arr[j]; j--)
				arr[j + 1] = arr[j];
			
			arr[j + 1] = aux;
			
		}	
		
	}
	
	public static void algoritmoInsertionSort(long[] A){
		
		int i, j;
		long aux;

		for(i = 1; i < A.length; i++){
			
			aux = A[i];
			
			for(j = i - 1; j >= 0 && aux < A[j]; j--)
				A[j + 1] = A[j];
			
			A[j + 1] = aux;
			
		}	
		
	}
	
	public static void algoritmoInsertionSort(long[] A, int inf, int nElem){
		
		int i, j;
		long aux;

		for(i = inf + 1; i < nElem; i++){
			
			aux = A[i];
			
			for(j = i - 1; j >= 0 && aux < A[j]; j--)
				A[j + 1] = A[j];
			
			A[j + 1] = aux;
			
		}	
		
	}
	
}

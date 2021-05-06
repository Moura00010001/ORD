package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SelectionSort{

	private static final String DIRETORIO = "recursos/";
	
	private long[] arr;	
	
	public SelectionSort(String nomeArquivo){
		carregarArquivoParaVetor(nomeArquivo);
		algoritmoSelectionSort();
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
	
	private void algoritmoSelectionSort(){
		
		int i, j, iMenor;
		
		for(i = 0; i < arr.length - 1; i++){
			
			iMenor = i;
						
			for(j = i + 1; j < arr.length; j++)
				if(arr[j] < arr[iMenor])
					iMenor = j;
			
			if(i != iMenor){				
				long aux = arr[i];
				arr[i] = arr[iMenor];
				arr[iMenor] = aux;				
			}
			
		}	
		
	}
	
	public static void algoritmoSelectionSort(long[] A){
		
		int i, j, iMenor;
		
		for(i = 0; i < A.length - 1; i++){
			
			iMenor = i;
						
			for(j = i + 1; j < A.length; j++)
				if(A[j] < A[iMenor])
					iMenor = j;
			
			if(i != iMenor){				
				long aux = A[i];
				A[i] = A[iMenor];
				A[iMenor] = aux;				
			}
			
		}
		
	}
	
}

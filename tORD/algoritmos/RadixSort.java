package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RadixSort{
	
	private static final String DIRETORIO = "recursos/";
	
	private long k;
	private long[] arr;	
	
	public RadixSort(String nomeArquivo){
		carregarArquivoParaVetor(nomeArquivo);
		algoritmoRadixSort();
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
		k = Long.MIN_VALUE;
        
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
           			
           			if(arr[i] > k)
           				k = arr[i];
           			
           			i++;           			
           		}	
           		
        	}
        	
            reader.close();
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }
		
	}
	
	private void algoritmoRadixSort(){
		
		//List<ArrayList<Long>> listas = new ArrayList<ArrayList<Long>>();
		//for(int i = 0; i < 10; i++)			
		//	listas.add(new ArrayList<Long>());
				
		int d;
		if(k == 0)
			d = 1;
		else
			d = (int) (Math.floor(Math.log10(Math.abs(k))) + 1);
		
		long base = 1;
		
		for(int x = 0; x < d; x++){
			
			/*	
			for(int y = 0; y < arr.length; y++){
				
				int pos = (int) ((arr[y]/base) % 10);
				
				listas.get(pos).add(new Long(arr[y]));
															
			}			
			
			int l = listas.size();
			int c;
			int p = 0;
			
			for(int i = 0; i < l; i++){				
				c = listas.get(i).size();				
				
				for(int j = 0; j < c; j++)
					arr[p++] = listas.get(i).get(j);			
			}
			
			//if(x > 10)
			//	System.out.println("Here!");
			
			for(int g = 0; g < 10; g++)			
				listas.get(g).clear();
			*/
	
			arr = CountingSort.algoritmoCountingSort2(arr, base);
			base *= 10;
			
		}			
		
	}
	
	public static void algoritmoRadixSort(long A[]){
		
		long k = Long.MIN_VALUE;
		for(int i = 0; i < A.length; i++)
			if(A[i] > k)
				k = A[i];
				
		int d;
		if(k == 0)
			d = 1;
		else
			d = (int) (Math.floor(Math.log10(Math.abs(k))) + 1);
		
		long base = 1;
		
		for(int j = 0; j < d; j++){

			A = CountingSort.algoritmoCountingSort2(A, base);
			base *= 10;
			
		}
		
	}	

}

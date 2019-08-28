package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountingSort{
	
	private static final String DIRETORIO = "recursos/";
	
	private long maxValue, minValue;
	private long[] A, B; 
	
	public CountingSort(String nomeArquivo){
		carregarArquivoParaVetor(nomeArquivo);
		algoritmoCountingSort();
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
        maxValue = Long.MIN_VALUE;
        minValue = 0;
        
        try{
        	
        	linha = reader.readLine();
        	
          	value = (int) Integer.valueOf(linha);
           	
           	A = new long[value];
           	            	
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
           			
        			A[i] = Long.valueOf(linhaAtual[j]) * mult;
           			           			
           			if(A[i] > maxValue)
           				maxValue = A[i];
           			
           			if(A[i] < minValue)
           				minValue = A[i];
           			
           			i++;           			
           		}	
           		
        	}	
            
            reader.close();
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }
        
        ++maxValue;
		
	}
	
	private void algoritmoCountingSort(){
		
		B = new long[A.length];
		
		if((int) (maxValue - minValue) < 0)
			return;
		
		long[] C = new long[(int) (maxValue - minValue)];
		
		for(int x = 0; x < A.length; x++)
			C[(int) (A[x] - minValue)]++;
		
		for(int y = 1; y < C.length; y++)
			C[y] += C[y - 1];
		
		for(int z = A.length - 1; z >= 0; z--)
			B[(int) --C[(int) (A[z] - minValue)]] = A[z];
		
	}
	
	public static long[] algoritmoCountingSort(long[] A){
		
		long[] B = new long[A.length];
		
		long maxValue = Long.MIN_VALUE;
		long minValue = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] > maxValue)
				maxValue = A[i];
			
			if(A[i] < minValue)
				minValue = A[i];			
		}	
		++maxValue;
		
		if((int) (maxValue - minValue) < 0)
			return null;
		
		long[] C = new long[(int) (maxValue - minValue)];
		
		for(int x = 0; x < A.length; x++)
			C[(int) (A[x] - minValue)]++;
		
		for(int y = 1; y < C.length; y++)
			C[y] += C[y - 1];
		
		for(int z = A.length - 1; z >= 0; z--)
			B[(int) --C[(int) (A[z] - minValue)]] = A[z];
		
		return B;
		
	}
	
	public static long[] algoritmoCountingSort2(long A[], long base){
		
		long B[] = new long[A.length];
		
		int index = -9;
		int[] C = new int[(int) (10 - index)];
		
		for(int x = 0; x < A.length; x++)
			C[(int) (((A[x]/base) % 10) - index)]++;
		
		for(int y = 1; y < C.length; y++)
			C[y] += C[y - 1];
		
		for(int z = A.length - 1; z >= 0; z--)
			B[--C[(int) (((A[z]/base) % 10) - index)]] = A[z];
		
		return B;
		
	}

	public long[] getVetorA(){
		return A;
	}

	public long[] getVetorB(){
		return B;
	}
	
}

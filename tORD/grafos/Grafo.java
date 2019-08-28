package grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grafo{
	
	private static final String DIRETORIO = "recursos/";
	
	private List<ArrayList<Vertice>> listaAdjacencia;
	private int[][] matrizAdjacencia;
	
	private ArrayList<Vertice> vertices;
	private int totalVertices;
		
	public Grafo(String nomeArquivo){
		
		carregarArquivoParaGrafo(nomeArquivo);
				
	}
	
	/*public void inicializarListaAjacencia(){
		
		listaAdjacencia = new ArrayList<ArrayList<Vertice>>();
		
		ArrayList<Vertice> v = new ArrayList<Vertice>();
		
		for(int i = 0; i < totalVertices; i++){
			
			listaAdjacencia.add(new ArrayList<Vertice>());
		
			v.add(new Vertice(i, (int) Double.POSITIVE_INFINITY, null));
									
		}	
		
        for(int i = 0; i < totalVertices; i++){
    		
    		for(int j = 0; j < totalVertices; j++){
    			
    			if(i == j){
    				
    				//matrizAdjacencia[i][j] = 0;
    				continue;
    				
    			}      			
    			
    			listaAdjacencia.get(i).add(v.get(j));
    			
    		}        		
    		
    	}
		
	}*/
	
	/*private void inicializarMatrizAdjacencia(BufferedReader reader){
		
		String linha;
		int multiplicador = 1;
        int n;
        
        try{
        	
        	linha = reader.readLine();
        	
          	n = (int) Integer.valueOf(linha);
           	
           	matrizAdjacencia = new int[n][n];
           	            	
           	for(int i = 0; i < n - 1; i++){
            		
           		linha = reader.readLine();
           		String[] linhaAtual = linha.split(" ");
            		
           		for(int j = i + 1; j < n; j++){
            			
           			matrizAdjacencia[i][j] = (int) Integer.valueOf(linhaAtual[j - 1*multiplicador]);
           			matrizAdjacencia[j][i] = (int) Integer.valueOf(linhaAtual[j - 1*multiplicador]);
            			
           		}
            		
           		multiplicador++;
            		
           	}	
            
            reader.close();
            
            totalVertices = n;
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }
		
	}*/
	
	public void inicializarArrayVertices(int verticeS){
		
		vertices = new ArrayList<Vertice>();
		
		for(int i = 0; i < totalVertices; i ++) {
			
			Vertice v = new Vertice(i, (int) Double.POSITIVE_INFINITY, null);
			vertices.add(v);
			
		}
		
		vertices.get(verticeS).setDistancia(0);
		
	}

	public void carregarArquivoParaGrafo(String nomeArquivo){
		
		// Parte de inicialização da Matriz de Adjacência
		
		FileReader isr = null;
        File txtFile = new File(DIRETORIO + nomeArquivo + ".txt");
        try{
            isr = new FileReader(txtFile);
        } catch(FileNotFoundException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }
        
        BufferedReader reader = new BufferedReader(isr);
        
		String linha;
		int multiplicador = 1;
        int nVertices;
        
        try{
        	
        	linha = reader.readLine();
        	
          	nVertices = (int) Integer.valueOf(linha);
           	
           	matrizAdjacencia = new int[nVertices][nVertices];
           	            	
           	for(int i = 0; i < nVertices - 1; i++){
            		
           		linha = reader.readLine();
           		String[] linhaAtual = linha.split(" ");
            		
           		for(int j = i + 1; j < nVertices; j++){
            			
           			matrizAdjacencia[i][j] = (int) Integer.valueOf(linhaAtual[j - 1*multiplicador]);
           			matrizAdjacencia[j][i] = (int) Integer.valueOf(linhaAtual[j - 1*multiplicador]);
            			
           		}
            		
           		multiplicador++;
            		
           	}	
            
            reader.close();
            
            totalVertices = nVertices;
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }
        
		// Parte de inicialização da Lista de Adjacência
        
		listaAdjacencia = new ArrayList<ArrayList<Vertice>>();
		
		for(int i = 0; i < totalVertices; i++){
			
			listaAdjacencia.add(new ArrayList<Vertice>());
									
		}	
        
        //inicializarMatrizAdjacencia(reader);
        //inicializarListaAjacencia();
        //inicializarArrayVertices(0);
		
	}
	
	public List<ArrayList<Vertice>> getListaAdjacencia(){
		return listaAdjacencia;
	}
	
	public ArrayList<Vertice> getVertices(){
		return vertices;
	}
	
	public int getTotalVertices(){
		return totalVertices;
	}
	
	public int getPesoAresta(int vInicial, int vFinal){
		
		return matrizAdjacencia[vInicial][vFinal];
		
	}
	
}


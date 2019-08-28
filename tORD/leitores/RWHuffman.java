package leitores;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import algoritmos.Huffman;
import estruturas.Codigo;
import heaps.HeapHuffman;
import nodes.NoArvore;

public class RWHuffman{
	
	private static final String DIRETORIO = "recursos/";
	
	public static int[] carregarArquivoParaVetorFrequencia(String nomeArquivo){
		
		int[] vetorFrequencia = new int[256];

	    FileInputStream arquivo = null;
        File txtFile = new File(DIRETORIO + nomeArquivo);
        
        try{
        	
            arquivo = new FileInputStream(txtFile);
        
        } catch(FileNotFoundException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }

		byte caracter;
        
        try{        	
       	
        	while(true){
        		
       			int fimArquivo = arquivo.read();
       			
       			if(fimArquivo == -1)
       				break;
       			else
       				caracter = (byte) fimArquivo;
        		
        		int p = caracter & 0xFF;
        		short pos = caracter;
        		           		
        		if(caracter < 0)
        			//pos = (short) Byte.toUnsignedInt(caracter);
        			pos += 256;
           			
       			int novaFrequencia = vetorFrequencia[pos] + 1;
       			vetorFrequencia[pos] = novaFrequencia; 
    
        	}
        	
       		arquivo.close();
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }
        
        return vetorFrequencia;
		
	}
	
	/*public static int bitABit(Codigo codigo){
		
		int posBit1MaisSignificativo = 0;
		
		for(int i = 0; i < codigo.getnBits(); i++)
			if(codigo.getBitCod(i) == 1)
				posBit1MaisSignificativo = i;
		
		return posBit1MaisSignificativo;
		
	}*/
	
	public static void codificarArquivo(String nomeArquivoLeitura, String nomeArquivoEscrita, ArrayList<Codigo> codigos, int[] vetorFrequencia){
		
	    FileInputStream arquivo = null;
        File txtFile = new File(DIRETORIO + nomeArquivoLeitura);
        
        FileOutputStream stream = null;
        DataOutputStream dos = null;
        
        try{
        	
        	arquivo = new FileInputStream(txtFile);
        	
        	stream = new FileOutputStream(DIRETORIO + nomeArquivoEscrita);
        	dos =  new DataOutputStream(stream);
        
        } catch(FileNotFoundException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }
        
        try{
        	
        	//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(stream));

        	for(int i = 0; i < vetorFrequencia.length; i++)            	
            	//if(vetorFrequencia.get(i) != null)
            		dos.writeInt(vetorFrequencia[i]);
            
            //bw.newLine();
     
        } catch (IOException e) {
        	System.err.println("Erro durante a escrita no arquivo!");
		}
        
		byte caracter;
		char b = 0, aux = 0;
		int posBit1MaisSignificativo, nBuf = 0;
		int posArray = 0;
        
        try{        	
        	
        	while(true){
       		
       			int fimArquivo = arquivo.read();
       			
       			if(fimArquivo == -1)
       				break;
       			else
       				caracter = (byte) fimArquivo;
        		
        		short pos = caracter;
        		
        		if(caracter < 0)
        			//pos = (short) Byte.toUnsignedInt(caracter);
        			pos += 256;
        		
    			//int id = heap.getVetor()[pos].getIdentificador();
    			Codigo c = codigos.get(pos);
        		//posBit1MaisSignificativo = bitABit(c);
        		
        		//if(nBuf != 0)
        		//	b = (char) (b << 8 - nBuf);
        		//System.out.println("b " + (int) b);
        		int tam = codigos.get(pos).getnBits();
        		
        		for(int j = 0; j < tam; j++){
        			
        			if(c.getBitCod(j) == 1){
        				
        				aux = (char) (1 << posArray);
        				//System.out.println("aux " + (int) aux);
        				
        			}
        				        				
        			b |= aux;
        			//System.out.println("b " + (int) b);
        			aux = 0;
        			nBuf++;
        			posArray++;
        			
        			if(nBuf == 8){

        				dos.write(b);
        				
        				b = 0;
        				nBuf = 0;
        				posArray = 0;
        				
        			}	
        			
        		}
        		
        	}
        	
       		arquivo.close();
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }        
        		
	}
	
	public static void decodificarArquivo(String nomeArquivoLeitura, String nomeArquivoEscrita){
		
	    FileInputStream arquivo = null;
        File txtFile = new File(DIRETORIO + nomeArquivoLeitura);
        
        FileOutputStream stream = null;
        
        ByteBuffer bb = null;
        byte[] inteiro = new byte[4];
        
		int[] vetorFrequencia = new int[256];
        ArrayList<Integer> vetor = new ArrayList<Integer>();
		ArrayList<NoArvore> v = new ArrayList<NoArvore>();
        
        try{
        	
        	arquivo = new FileInputStream(txtFile);
        	
        	stream = new FileOutputStream(DIRETORIO + nomeArquivoEscrita);
        
        } catch(FileNotFoundException e){
            System.err.println("Erro! Não foi possível encontrar o arquivo a ser carregado.");
        }
        
        try{

            for(int i = 0; i < vetorFrequencia.length; i++){
            	
            	for(int j = 0; j < 4; j++)            		
            		inteiro[j] = (byte) arquivo.read();
            
            	bb = ByteBuffer.wrap(inteiro);
            	int value = bb.getInt();
            	//if(value != 0)
            	//	System.out.println("aqui!");
            	vetorFrequencia[i] = value;
            	
            }
                       		            
            //bw.newLine();
     
        } catch (IOException e) {
        	System.err.println("Erro durante a escrita no arquivo!");
		}        
		 
		for(int j = 0; j < vetorFrequencia.length; j++){
			 
			if(vetorFrequencia[j] == 0)
				continue;
			
			vetor.add(vetorFrequencia[j]);
			v.add(new NoArvore(null, null, null, vetorFrequencia[j], j));
			 
		}
		
		HeapHuffman minHeap = Huffman.construirArvore(v);

		byte caracter;
		char aux1 = 1, aux2 = 0;
		
		NoArvore noAtual = minHeap.getVetor()[0];
        
        try{
        	
        	while(true){
        		
       			int fimArquivo = arquivo.read();
        		
       			if(fimArquivo == -1)
       				break;
       			else
       				caracter = (byte) fimArquivo;
       		
        		short pos = caracter;
        		
        		if(caracter < 0)
        			//pos = (short) Byte.toUnsignedInt(caracter);
        			pos += 256;
        		
        		byte bt = (byte) (caracter & 0xFF);
        		
        		for(int j = 0; j < 8; j++){
        			
        			//aux2 = (char) (fimArquivo >> j);
        			aux2 = (char) (caracter >> j);
        			//System.out.println("aux " + (int) aux2);
        			//int bit1 = aux; 
        			
        			if((aux1 & aux2) == 1)        				
        				noAtual = noAtual.getNoDireito();
        			
        			else
        				noAtual = noAtual.getNoEsquerdo();
        				        				
        			if(noAtual.isFolha()){
        				
        				stream.write(noAtual.getIdentificador());
        				noAtual = minHeap.getVetor()[0];
        				
        			}	
        			
        		}
    
        	}
        	
       		arquivo.close();
                
        } catch(IOException e){
            System.err.println("Erro ao tentar ler o arquivo");
        }        
        		
	}

}

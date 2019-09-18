package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort{

	private static final String DIRETORIO = "recursos/";
	
	private static final int PONTO_DE_CORTE = 3;
	
	private long[] arr;	
	
	public QuickSort(String nomeArquivo){
		carregarArquivoParaVetor(nomeArquivo);
		algoritmoQuickSort3(0, arr.length - 1);
	}
	
	public void carregarArquivoParaVetor(String nomeArquivo){
		
		FileReader isr = null;
        File txtFile = new File(DIRETORIO + nomeArquivo);
        try{
            isr = new FileReader(txtFile);
        } catch(FileNotFoundException e){
            System.err.println("Erro! N�o foi poss�vel encontrar o arquivo a ser carregado.");
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
	
	private static void trocaElemento(long[] arr, int ori, int dest){
		
		long aux = arr[ori];
		arr[ori] = arr[dest];
		arr[dest] = aux;
		
	}
		
	private void algoritmoQuickSort(int inf, int sup){
		
		int esq, dir, pivo;
		
		/* Se a tabela est� vazia ou cont�m apenas */
		/* um elemento, ela j� est� ordenada       */
		if (inf >= sup)
			return; /* A tabela j� est� ordenada */

		pivo = inf;

	    for(esq = inf, dir = sup; esq < dir; ){
	    	/* Enquanto os elementos forem menores do que */
	        /* o piv�, incrementa-se o �ndice esquerdo    */
	        while(arr[esq] <= arr[pivo] && esq < sup)
	        	++esq;

	        /* Enquanto os elementos forem maiores do que */
	        /* o piv�, decrementa-se o �ndice direito     */
	        while(arr[dir] > arr[pivo])
	        	--dir;

	        /* Se os �ndices se cruzarem, */
	        /* a divis�o foi conclu�da    */
	        if(esq >= dir)
	            break;

	        /* Os elementos nos �ndices esq e dir est�o  */
	        /* em parti��es erradas e devem ser trocados */
	        trocaElemento(arr, esq, dir);

	      }

	      /* Coloca o piv� em sua correta posi��o */
	      trocaElemento(arr, pivo, dir);

	      algoritmoQuickSort(inf, dir - 1);

	      algoritmoQuickSort(dir + 1, sup);
		
	}
	
	public static void algoritmoQuickSort(long[] A, int inf, int sup){
		
		int esq, dir, pivo;
		
	   /* Se a tabela est� vazia ou cont�m apenas */
	   /* um elemento, ela j� est� ordenada       */
	   if (inf >= sup)
	      return; /* A tabela j� est� ordenada */

		pivo = inf;

	    for(esq = inf, dir = sup; esq < dir; ){
	    	/* Enquanto os elementos forem menores do que */
	        /* o piv�, incrementa-se o �ndice esquerdo    */
	        while(A[esq] <= A[pivo] && esq < sup)
	        	++esq;

	        /* Enquanto os elementos forem maiores do que */
	        /* o piv�, decrementa-se o �ndice direito     */
	        while(A[dir] > A[pivo])
	        	--dir;

	        /* Se os �ndices se cruzarem, */
	        /* a divis�o foi conclu�da    */
	        if(esq >= dir)
	            break;

	        /* Os elementos nos �ndices esq e dir est�o  */
	        /* em parti��es erradas e devem ser trocados */
	        trocaElemento(A, esq, dir);

	      }

	      /* Coloca o piv� em sua correta posi��o */
	      trocaElemento(A, pivo, dir);

	      algoritmoQuickSort(A, inf, dir - 1);

	      algoritmoQuickSort(A, dir + 1, sup);
		
	}
	
	private void algoritmoQuickSort2(int inf, int sup){

		int esq, dir, pivo, i,
	    media = 0, count = 7, nElem = sup - inf + 1;  
		
		/* Se a tabela est� vazia ou cont�m apenas */
		/* um elemento, ela j� est� ordenada       */
		if (inf >= sup)
			return; /* A tabela j� est� ordenada */
		
		if(nElem >= 7){
			
			for(i = inf; count > 0; i++, count--)
				media += i;
			
			media /= 7;
			
			trocaElemento(arr, inf, media);			
		}	

		pivo = inf;

	    for(esq = inf, dir = sup; esq < dir; ){
	    	/* Enquanto os elementos forem menores do que */
	        /* o piv�, incrementa-se o �ndice esquerdo    */
	        while(arr[esq] <= arr[pivo] && esq < sup)
	        	++esq;

	        /* Enquanto os elementos forem maiores do que */
	        /* o piv�, decrementa-se o �ndice direito     */
	        while(arr[dir] > arr[pivo])
	        	--dir;

	        /* Se os �ndices se cruzarem, */
	        /* a divis�o foi conclu�da    */
	        if(esq >= dir)
	            break;

	        /* Os elementos nos �ndices esq e dir est�o  */
	        /* em parti��es erradas e devem ser trocados */
	        trocaElemento(arr, esq, dir);

	      }

	      /* Coloca o piv� em sua correta posi��o */
	      trocaElemento(arr, pivo, dir);

	      algoritmoQuickSort2(inf, dir - 1);

	      algoritmoQuickSort2(dir + 1, sup);
		
	}
	
	public static void algoritmoQuickSort2(long[] A, int inf, int sup){
		
		int esq, dir, pivo, i,
	    media = 0, count = 7, nElem = sup - inf + 1;
		
		/* Se a tabela est� vazia ou cont�m apenas */
		/* um elemento, ela j� est� ordenada       */
		if (inf >= sup)
			return; /* A tabela j� est� ordenada */
		
		if(nElem >= 7){
			
			for(i = inf; count > 0; i++, count--)
				media += i;
			
			media /= 7;
			
			trocaElemento(A, inf, media);			
		}	

		pivo = inf;

	    for(esq = inf, dir = sup; esq < dir; ){
	    	/* Enquanto os elementos forem menores do que */
	        /* o piv�, incrementa-se o �ndice esquerdo    */
	        while(A[esq] <= A[pivo] && esq < sup)
	        	++esq;

	        /* Enquanto os elementos forem maiores do que */
	        /* o piv�, decrementa-se o �ndice direito     */
	        while(A[dir] > A[pivo])
	        	--dir;

	        /* Se os �ndices se cruzarem, */
	        /* a divis�o foi conclu�da    */
	        if(esq >= dir)
	            break;

	        /* Os elementos nos �ndices esq e dir est�o  */
	        /* em parti��es erradas e devem ser trocados */
	        trocaElemento(A, esq, dir);

	      }

	      /* Coloca o piv� em sua correta posi��o */
	      trocaElemento(A, pivo, dir);

	      algoritmoQuickSort2(A, inf, dir - 1);

	      algoritmoQuickSort2(A, dir + 1, sup);
		
	}
	
	private void algoritmoQuickSort3(int inf, int sup){
		
		int meio, esq, dir, pivo;
		
		/* Se a tabela est� vazia ou cont�m apenas */
		/* um elemento, ela j� est� ordenada       */
		if (inf >= sup)
			return; /* A tabela j� est� ordenada */
		
	   /* Se o tamanho da tabela ficar abaixo do ponto de */
	   /* corte, chama InsertionSort() para orden�-la     */
	   if(sup - inf + 1 <= PONTO_DE_CORTE)
		   InsertionSort.algoritmoInsertionSort(arr, inf, sup - inf + 1);	      
	   else{
	      /*                                             */
	      /* Escolhe o piv� usando mediana de tr�s. Al�m */
	      /* disso, ao final, os elementos nas posi��es  */
	      /* inf, sup e meio estar�o ordenados.          */
	      /*                                             */

	     meio = (inf + sup)/2;

	     /* Ordena o elemento do meio e o primeiro elemento */
	     if(arr[meio] < arr[inf])
	         trocaElemento(arr, inf, meio);

	     /* Ordena o primeiro e o �ltimo elementos */
	     if(arr[sup] < arr[inf])
	         trocaElemento(arr, inf, sup);

	     /* Ordena o elemento do meio e o �ltimo elemento */
	     if(arr[sup] < arr[meio])
	         trocaElemento(arr, meio, sup);

	     trocaElemento(arr, meio, inf);

	     pivo = inf;

	    for(esq = inf, dir = sup; esq < dir; ){
	    	/* Enquanto os elementos forem menores do que */
	        /* o piv�, incrementa-se o �ndice esquerdo    */
	        while(arr[esq] <= arr[pivo] && esq < sup)
	        	++esq;

	        /* Enquanto os elementos forem maiores do que */
	        /* o piv�, decrementa-se o �ndice direito     */
	        while(arr[dir] > arr[pivo])
	        	--dir;

	        /* Se os �ndices se cruzarem, */
	        /* a divis�o foi conclu�da    */
	        if(esq >= dir)
	            break;

	        /* Os elementos nos �ndices esq e dir est�o  */
	        /* em parti��es erradas e devem ser trocados */
	        trocaElemento(arr, esq, dir);

	      }

	      /* Coloca o piv� em sua correta posi��o */
	      trocaElemento(arr, pivo, dir);

	      algoritmoQuickSort3(inf, dir - 1);

	      algoritmoQuickSort3(dir + 1, sup);
	      
	   }      
		
	}
	
	public static void algoritmoQuickSort3(long[] A, int inf, int sup){
		
		int meio, esq, dir, pivo;
		
		/* Se a tabela est� vazia ou cont�m apenas */
		/* um elemento, ela j� est� ordenada       */
		if (inf >= sup)
			return; /* A tabela j� est� ordenada */
		
	   /* Se o tamanho da tabela ficar abaixo do ponto de */
	   /* corte, chama InsertionSort() para orden�-la     */
	   if(sup - inf + 1 <= PONTO_DE_CORTE)
	      InsertionSort.algoritmoInsertionSort(A, inf, sup - inf + 1);
	   else{
	      /*                                             */
	      /* Escolhe o piv� usando mediana de tr�s. Al�m */
	      /* disso, ao final, os elementos nas posi��es  */
	      /* inf, sup e meio estar�o ordenados.          */
	      /*                                             */

		 meio = (inf + sup)/2;

	     /* Ordena o elemento do meio e o primeiro elemento */
	     if(A[meio] < A[inf])
	         trocaElemento(A, inf, meio);

	     /* Ordena o primeiro e o �ltimo elementos */
	     if(A[sup] < A[inf])
	         trocaElemento(A, inf, sup);

	     /* Ordena o elemento do meio e o �ltimo elemento */
	     if(A[sup] < A[meio])
	         trocaElemento(A, meio, sup);

	     trocaElemento(A, meio, inf);

	     pivo = inf;

	    for(esq = inf, dir = sup; esq < dir; ){
	    	/* Enquanto os elementos forem menores do que */
	        /* o piv�, incrementa-se o �ndice esquerdo    */
	        while(A[esq] <= A[pivo] && esq < sup)
	        	++esq;

	        /* Enquanto os elementos forem maiores do que */
	        /* o piv�, decrementa-se o �ndice direito     */
	        while(A[dir] > A[pivo])
	        	--dir;

	        /* Se os �ndices se cruzarem, */
	        /* a divis�o foi conclu�da    */
	        if(esq >= dir)
	            break;

	        /* Os elementos nos �ndices esq e dir est�o  */
	        /* em parti��es erradas e devem ser trocados */
	        trocaElemento(A, esq, dir);

	      }

	    /* Coloca o piv� em sua correta posi��o */
	    trocaElemento(A, pivo, dir);

	    algoritmoQuickSort3(A, inf, dir - 1);

	    algoritmoQuickSort3(A, dir + 1, sup);
	      
	   }  
		
	}
	
}

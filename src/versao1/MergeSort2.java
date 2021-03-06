package versao1;

public class MergeSort2 {

	
	
	 public static void main(String[] args) {
		    //Cria um vetor de inteiros e atribui os valores.
		    int[] numeros = {3, 9, 8, 7, 6, 2, 1};
		    
		    //Chama o m?todo que vai executar o algoritmo do Merge Sort.
		    mergeSort(numeros.length, numeros);
		    
		    //Imprime os valores do vetor ap?s ser ordenados pelo Merge Sort.
		    for(int x : numeros) {
		      System.out.print(x + " ");
		    }
		  }
		  
		  /**
		   * M?todo que ordena um vetor de elementos inteiros, utilizando o algoritmo
		   * do Merge Sort.
		   * 
		   * @param tamanho - Tamanho do vetor.
		   * @param vetor  - Vetor de n?meros inteiros.
		   */
		  private static void mergeSort(int tamanho, int[] vetor) {
		    /* Variavel utilizada para percorrer o vetor. 
		      Inicializa com 1 para indicar que o vetor tenha pelo menos 1 elemento. */
		    int elementos = 1;
		    /* Variaveis utilizadas para marcar o inicio, meio e fim do vetor. */
		    int inicio, meio, fim;
		    
		    /* Percorre os elementos do vetor at? chegar no fim do vetor. */
		    while(elementos < tamanho) {
		      /* Aponta o inicio do vetor. */
		      inicio = 0;
		      
		      /* Percorre o vetor do inicio + quantidade de elementos ja percorrido, 
		        at? o tamanho do vetor. */
		      while(inicio + elementos < tamanho) {
		        /* Guarda a posi??o do meio do vetor que ser? ordenado. */
		        meio = inicio + elementos;
		        /* Guarda a posi??o final do vetor que ser? ordenado. */
		        fim = inicio + 2 * elementos;
		        
		        /* Caso o fim fique com um tamanho maior, que o tamanho do vetor,
		         ent?o faz o fim ter o mesmo tamanho que o tamanho do vetor. */
		        if(fim > tamanho)
		          fim = tamanho;
		        
		        /* Chama o m?todo que faz a intercala??o dos valores
		          ordenados do vetor. */
		        intercala(vetor, inicio, meio, fim);
		        
		        /* Faz o inicio do vetor ser igual ao fim. */
		        inicio = fim;
		      }
		      
		      /* Percorre o vetor dobrando a quantidade de itens ja ordenados. */
		      elementos = elementos * 2;
		    }
		  }
	
	
	/**
	   * M?todo responsavel por intercalar os valores do vetor de forma ordenada.
	   * 
	   * @param vetor - Vetor que ter? seus valores ordenados.
	   * @param inicio - Posi??o inicial da ordena??o no vetor.
	   * @param meio  - Posi??o do meio da ordena??o no vetor.
	   * @param fim  - Posi??o final da ordena??o no vetor.
	   */
	  private static void intercala(int[] vetor, int inicio, int meio, int fim) {
	    /* Vetor utilizado para guardar os valors ordenados. */
	    int novoVetor[] = new int[fim - inicio];
	    /* Variavel utilizada para guardar a posicao do inicio do vetor. */
	    int i = inicio;
	    /* Variavel utilizada para guardar a posi??o do meio do vetor. */
	    int m = meio;
	    /* Variavel utilizada para guarda a posi??o onde os
	      valores ser?o inseridos no novo vetor. */
	    int pos = 0;
	    
	    /* Enquanto o inicio n?o chegar at? o meio do vetor, ou o meio do vetor
	      n?o chegar at? seu fim, compara os valores entre o inicio e o meio,
	      verificando em qual ordem vai guarda-los ordenado.*/
	    while(i < meio && m < fim) {
	      /* Se o vetor[i] for menor que o vetor[m], ent?o guarda o valor do
	        vetor[i] pois este ? menor. */
	      if(vetor[i] <= vetor[m]) {
	        novoVetor[pos] = vetor[i];
	        pos = pos + 1;
	        i = i + 1;
	      // Sen?o guarda o valor do vetor[m] pois este ? o menor.
	      } else {
	        novoVetor[pos] = vetor[m];
	        pos = pos + 1;
	        m = m + 1;
	      }
	    }
	    
	    // Adicionar no vetor os elementos que est?o entre o inicio e meio,
	    // que ainda n?o foram adicionados no vetor.
	    while(i < meio) {
	      novoVetor[pos] = vetor[i];
	      pos = pos + 1;
	      i = i + 1;
	    }
	    
	    // Adicionar no vetor os elementos que est?o entre o meio e o fim,
	    // que ainda n?o foram adicionados no vetor.
	    while(m < fim) {
	      novoVetor[pos] = vetor[m];
	      pos = pos + 1;
	      m = m + 1;
	    }
	    
	    // Coloca no vetor os valores j? ordenados.
	    for(pos = 0, i = inicio; i < fim; i++, pos++) {
	      vetor[i] = novoVetor[pos];
	    }
	  }
	}

